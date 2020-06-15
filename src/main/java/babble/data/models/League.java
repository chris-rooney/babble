package babble.data.models;

import javax.persistence.*;
import java.util.Set;

// TODO Would be nice to get around all the Entity/Repository/Dto/Payload boilerplate.
//  Dunno if it makes sense to lump all (or some) of those in an interface or factory or whatever but worth looking into
@Entity
@Table(name = "league")
public class League extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long leagueId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "league")
    private Set<Season> seasons;

    @ManyToMany
    @JoinTable(name = "user_league", joinColumns = {@JoinColumn(name = "league_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> coaches;

    // For Hibernate
    protected League() {
    }

    public League(final String name) {
        this.name = name;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public String getName() {
        return name;
    }

    public League setName(final String name) {
        this.name = name;
        return this;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public Set<User> getCoaches() {
        return coaches;
    }
}
