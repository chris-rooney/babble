package babble.data.access.rules;

import babble.data.models.gamerules.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
