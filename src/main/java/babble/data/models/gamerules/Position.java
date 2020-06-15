package babble.data.models.gamerules;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position extends BaseGameRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "name")
    private String name;

    @Column(name = "max")
    private int max;

    @Column(name = "base_movement")
    private int baseMovement;

    @Column(name = "base_strength")
    private int baseStrength;

    @Column(name = "base_agility")
    private int baseAgility;

    @Column(name = "base_armor")
    private int baseArmor;

    @Column(name = "base_value")
    private int baseValue;

    // TODO Join Table
    @Column(name = "normal_skill_categories")
    private String normalSkillCategories;

    @Column(name = "doubles_skill_categories")
    private String doublesSkillCategories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Race race;

    @ManyToMany
    @JoinTable(name = "position_skill", joinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "position_id", referencedColumnName = "id")})
    private Set<Skill> skills;

    // For Hibernate
    protected Position() {
    }

    public Position(final Long raceId, final String name, final int max, final int baseMovement, final int baseStrength, final int baseAgility, final int baseArmor, final int baseValue, final String normalSkillCategories, final String doublesSkillCategories) {
        this.raceId = raceId;
        this.name = name;
        this.max = max;
        this.baseMovement = baseMovement;
        this.baseStrength = baseStrength;
        this.baseAgility = baseAgility;
        this.baseArmor = baseArmor;
        this.baseValue = baseValue;
        this.normalSkillCategories = normalSkillCategories;
        this.doublesSkillCategories = doublesSkillCategories;
    }

    public Long getId() {
        return id;
    }

    public Long getRaceId() {
        return raceId;
    }

    public Position setRaceId(final Long raceId) {
        this.raceId = raceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Position setName(final String name) {
        this.name = name;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Position setMax(final int max) {
        this.max = max;
        return this;
    }

    public int getBaseMovement() {
        return baseMovement;
    }

    public Position setBaseMovement(final int baseMovement) {
        this.baseMovement = baseMovement;
        return this;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public Position setBaseStrength(final int baseStrength) {
        this.baseStrength = baseStrength;
        return this;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public Position setBaseAgility(final int baseAgility) {
        this.baseAgility = baseAgility;
        return this;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public Position setBaseArmor(final int baseArmor) {
        this.baseArmor = baseArmor;
        return this;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public Position setBaseValue(final int baseValue) {
        this.baseValue = baseValue;
        return this;
    }

    public String getNormalSkillCategories() {
        return normalSkillCategories;
    }

    public Position setNormalSkillCategories(final String normalSkillCategories) {
        this.normalSkillCategories = normalSkillCategories;
        return this;
    }

    public String getDoublesSkillCategories() {
        return doublesSkillCategories;
    }

    public Position setDoublesSkillCategories(final String doublesSkillCategories) {
        this.doublesSkillCategories = doublesSkillCategories;
        return this;
    }

    public Race getRace() {
        return race;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
