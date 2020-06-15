package babble.data.access;

import babble.data.models.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends RefreshableRepository<Player, Long> {

    List<Player> findByTeamIdAndActive(final long teamId, final boolean active);
}