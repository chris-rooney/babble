package babble.data.access;

import babble.data.models.League;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends RefreshableRepository<League, Long> {
}
