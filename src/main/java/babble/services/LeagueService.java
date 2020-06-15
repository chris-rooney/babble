package babble.services;

import babble.data.access.LeagueRepository;
import babble.data.access.UserRepository;
import babble.data.models.League;
import babble.data.models.User;
import babble.services.output.LeagueDto;
import babble.services.output.SeasonDto;
import babble.services.output.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private UserRepository userRepository;

    public List<LeagueDto> list() {
        return leagueRepository.findAll().stream()
                .map(LeagueService::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public LeagueDto findById(final long leagueId) {
        return toDto(leagueRepository.findById(leagueId).orElse(null));
    }

    public LeagueDto create(final String leagueName) {
        final League league = new League(leagueName);
        return toDto(leagueRepository.save(league));
    }

    public void subscribeCoach(final long leagueId, final long coachId) {
        final League league = leagueRepository.findById(leagueId).orElse(null);
        final User coach = userRepository.findById(coachId).orElse(null);

        if (league == null || coach == null) {
            // TODO
            // Can also shortcut in between gets
            return;
        }
        // TODO Check if already subbed
        league.getCoaches().add(coach);
        leagueRepository.save(league);
    }

    static LeagueDto toDto(final League league) {
        if (league == null) {
            return null;
        }
        final List<SeasonDto> seasons = league.getSeasons().stream()
                .map(SeasonService::toDto)
                .collect(Collectors.toList());
        final List<UserDto> coaches = league.getCoaches().stream()
                .map(UserService::toDto)
                .collect(Collectors.toList());
        return LeagueDto.newBuilder()
                .setId(league.getLeagueId())
                .setName(league.getName())
                .setSeasons(seasons)
                .setCoaches(coaches)
                .build();
    }
}
