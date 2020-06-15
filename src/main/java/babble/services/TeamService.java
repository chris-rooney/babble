package babble.services;

import babble.data.access.PlayerRepository;
import babble.data.access.PlayerStateRepository;
import babble.data.access.TeamRepository;
import babble.data.access.TeamStateRepository;
import babble.data.access.rules.InjuryRepository;
import babble.data.access.rules.PositionRepository;
import babble.data.access.rules.SkillRepository;
import babble.data.models.Player;
import babble.data.models.PlayerState;
import babble.data.models.Team;
import babble.data.models.TeamState;
import babble.data.models.gamerules.Injury;
import babble.data.models.gamerules.Skill;
import babble.services.output.PlayerDto;
import babble.services.output.TeamDto;
import babble.services.output.UserDto;
import babble.services.output.rules.RaceDto;
import babble.services.roster.data.Roster;
import babble.services.roster.data.RosterPlayer;
import babble.services.roster.reader.HalfingScribeRosterReader;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamService {

    // TODO Configure logging output
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    private final TeamRepository teamRepository;
    private final TeamStateRepository teamStateRepository;
    private final PlayerRepository playerRepository;
    private final PlayerStateRepository playerStateRepository;
    private final PositionRepository positionRepository;
    private final SkillRepository skillRepository;
    private final InjuryRepository injuryRepository;

    @Autowired
    public TeamService(final TeamRepository teamRepository, final TeamStateRepository teamStateRepository, final PlayerRepository playerRepository, final PlayerStateRepository playerStateRepository, final PositionRepository positionRepository, final SkillRepository skillRepository, final InjuryRepository injuryRepository) {
        this.teamRepository = teamRepository;
        this.teamStateRepository = teamStateRepository;
        this.playerRepository = playerRepository;
        this.playerStateRepository = playerStateRepository;
        this.positionRepository = positionRepository;
        this.skillRepository = skillRepository;
        this.injuryRepository = injuryRepository;
    }

    public List<TeamDto> getAllTeams() {
        logger.debug("Get All Teams");
        return teamRepository.findAll().stream()
                .map(TeamService::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public TeamDto findById(final long id) {
        logger.debug("Get Team {}", id);
        return toDto(teamRepository.findById(id).orElse(null));
    }

    @Transactional
    public TeamDto createTeam(final long coachUserId, final long leagueId, final long raceId, final String teamName) {
        logger.debug("Create Team {} for {}", teamName, coachUserId);
        Team team = new Team(coachUserId, leagueId, raceId, teamName);
        team = teamRepository.save(team);
        teamRepository.refresh(team); // TODO Looks like this was working on populating links on updates - did it work?
        return toDto(team);
    }

    @Transactional
    public void processUpload(final long teamId, final Workbook rosterFile) {
        logger.debug("Processing uploaded roster for team {}", teamId);
        final Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) {
            // TODO Logging/exception
            return;
        }
        final Roster roster = new HalfingScribeRosterReader().readRoster(rosterFile);
        logger.debug("Roster: {}", roster);
        // TODO Validator
        // TODO Apply updates
        final TeamState teamState = teamStateRepository.save(
                new TeamState(teamId, roster.getRerolls(), roster.getFanFactor(), roster.getAssistantCoaches(), roster.getCheerleaders(), roster.getApothecary() > 0, roster.getTreasury()));
        final List<Player> players = playerRepository.findByTeamIdAndActive(teamId, true);
        players.forEach(x -> updatePlayer(teamState.getTeamStateId(), x, roster.getPlayersByJersey().getOrDefault(x.getJersey(), null)));
        // TODO New players
        final List<Integer> previousPlayerJerseys = players.stream().map(Player::getJersey).collect(Collectors.toList());
        roster.getPlayersByJersey().entrySet().stream()
                .filter(e -> !previousPlayerJerseys.contains(e.getKey()))
                .forEach(e -> createPlayer(teamId, team.getRaceId(), teamState.getTeamStateId(), e.getValue()));
    }

    private void updatePlayer(final long teamStateId, final Player player, final RosterPlayer update) {
        final PlayerState playerState = new PlayerState(player.getPlayerId(), teamStateId, update.getStatus(), update.getCompletions(), update.getTouchdowns(), update.getInterceptions(), update.getCasualties(), update.getMvps(), update.getValue());
        final List<String> skillAndInjuryNames = Arrays.asList(update.getSkillsAndInjuries().split(", "));
        final List<Skill> skills = skillRepository.findByNameIn(skillAndInjuryNames);
        final List<Injury> injuries = injuryRepository.findByNameIn(skillAndInjuryNames);
        // TODO Validation: value sum, skill1-6, etc
        skills.forEach(s -> playerState.getSkills().add(s));
        injuries.forEach(i -> playerState.getInjuries().add(i));
        playerStateRepository.save(playerState);
    }

    private void createPlayer(final long teamId, final long raceId, final long teamStateId, final RosterPlayer create) {
        final Player player = playerRepository.save(new Player()
                .setTeamId(teamId)
                .setJersey(create.getNumber())
                .setPositionId(positionRepository.findByRaceIdAndName(raceId, create.getPosition()).getId())
                .setName(create.getName())
                .setActive(true));
        updatePlayer(teamStateId, player, create);
    }

    static TeamDto toDto(final Team team) {
        if (team == null) {
            return null;
        }
        final UserDto coach = UserService.toDto(team.getCoach());
        final RaceDto race = RulesService.raceToDto(team.getRace());
        final List<PlayerDto> players = team.getPlayers().stream()
                .map(TeamService::playerToDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        // TODO Current state, history
        return TeamDto.newBuilder()
                .setId(team.getTeamId())
                .setName(team.getTeamName())
                .setCoach(coach)
                .setRace(race)
                .setPlayers(players)
                .build();
    }

    static PlayerDto playerToDto(final Player player) {
        if (player == null) {
            return null;
        }
        return PlayerDto.newBuilder()
                .setName(player.getName())
                .build();
    }
}
