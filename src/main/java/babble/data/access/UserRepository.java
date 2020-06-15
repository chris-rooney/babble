package babble.data.access;

import babble.data.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends RefreshableRepository<User, Long> {

    // TODO Link table
//    List<User> findAllByLeagueId(final long leagueId);
}
