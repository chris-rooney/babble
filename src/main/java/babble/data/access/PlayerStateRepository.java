package babble.data.access;

import babble.data.models.PlayerState;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStateRepository extends RefreshableRepository<PlayerState, Long> {

}

