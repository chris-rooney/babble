package babble.data.access;

import babble.data.models.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends RefreshableRepository<Team, Long> {

}
