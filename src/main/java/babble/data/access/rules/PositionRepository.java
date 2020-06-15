package babble.data.access.rules;

import babble.data.models.gamerules.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findByRaceId(final long raceId);

    Position findByRaceIdAndName(final long raceId, final String name);
}

