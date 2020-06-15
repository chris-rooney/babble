package babble.data.access;

import babble.data.models.Season;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends RefreshableRepository<Season, Long> {

    List<Season> findByLeagueId(final long leagueId);
}
