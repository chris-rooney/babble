package babble.data.access;

import babble.data.models.TeamState;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamStateRepository extends RefreshableRepository<TeamState, Long> {

}

