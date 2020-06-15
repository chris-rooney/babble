package babble.services;

import babble.data.access.SeasonRepository;
import babble.data.access.TeamRepository;
import babble.data.models.Season;
import babble.data.models.Team;
import babble.services.output.SeasonDto;
import babble.services.output.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<SeasonDto> getAllForLeague(final long leagueId) {
        return seasonRepository.findByLeagueId(leagueId).stream()
                .map(SeasonService::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public SeasonDto findById(final long seasonId) {
        return toDto(seasonRepository.findById(seasonId).orElse(null));
    }

    public SeasonDto create(final long leagueId, final String name) {
        final Season season = new Season(name, leagueId);
        return toDto(seasonRepository.save(season));
    }

    public void subscribeTeam(final long seasonId, final long teamId) {
        final Season season = seasonRepository.findById(seasonId).orElse(null);
        final Team team = teamRepository.findById(teamId).orElse(null);

        if (season == null || team == null) {
            // TODO
            // Can also shortcut in between gets
            return;
        }
        // TODO Check if already subbed
        season.getTeams().add(team);
        seasonRepository.save(season);
    }

    static SeasonDto toDto(final Season season) {
        if (season == null) {
            return null;
        }
        final List<TeamDto> teams = season.getTeams().stream()
                .map(TeamService::toDto)
                .collect(Collectors.toList());
        return SeasonDto.newBuilder()
                .setId(season.getSeasonId())
                .setName(season.getName())
                .setLeagueId(season.getLeagueId())
                .setTeams(teams)
                .build();
    }
}
