package babble.data.access.rules;

import babble.data.access.RefreshableRepository;
import babble.data.models.gamerules.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends RefreshableRepository<Skill, Long> {

    // TODO RuleSet filter
    List<Skill> findByNameIn(List<String> names);
}
