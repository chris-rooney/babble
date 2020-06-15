package babble.data.access.rules;


import babble.data.access.RefreshableRepository;
import babble.data.models.gamerules.Injury;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjuryRepository extends RefreshableRepository<Injury, Long> {

    // TODO RuleSet filter
    List<Injury> findByNameIn(List<String> names);
}
