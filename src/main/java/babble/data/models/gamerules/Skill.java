package babble.data.models.gamerules;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill extends BaseGameRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private SkillCategory category;

    // TODO Rules?

    // For Hibernate
    protected Skill() {
    }

    public Skill(final String name, final Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Skill setName(final String name) {
        this.name = name;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Skill setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public SkillCategory getCategory() {
        return category;
    }
}
