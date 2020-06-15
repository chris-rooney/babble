package babble.data.models.gamerules;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "race")
public class Race extends BaseGameRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "reroll_cost")
    private int rerollCost;

    @OrderBy("id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "race")
    private Set<Position> positions;

    // TODO Star Players - including rostered Stars

    // For Hibernate
    protected Race() {
    }

    // Read-Only entity

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Race setName(final String name) {
        this.name = name;
        return this;
    }

    public int getRerollCost() {
        return rerollCost;
    }

    public Race setRerollCost(final int rerollCost) {
        this.rerollCost = rerollCost;
        return this;
    }

    public Set<Position> getPositions() {
        return positions;
    }
}
