package babble.data.models.gamerules;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skill_category")
public class SkillCategory extends BaseGameRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Skill> skills;

    // For Hibernate
    protected SkillCategory() {
    }

    public SkillCategory(final String name, final String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SkillCategory setName(final String name) {
        this.name = name;
        return this;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public SkillCategory setAbbreviation(final String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
