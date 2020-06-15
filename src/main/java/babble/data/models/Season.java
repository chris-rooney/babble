package babble.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "season")
public class Season extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long seasonId;

    @Column(name = "name")
    private String name;

    @Column(name = "league_id")
    private long leagueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private League league;

    @ManyToMany
    @JoinTable(name = "team_season", joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "season_id", referencedColumnName = "id")})
    private Set<Team> teams;

    // For Hibernate
    protected Season() {
    }

    public Season(final String name, final long leagueId) {
        this.name = name;
        this.leagueId = leagueId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public String getName() {
        return name;
    }

    public Season setName(final String name) {
        this.name = name;
        return this;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public Season setLeagueId(final long leagueId) {
        this.leagueId = leagueId;
        return this;
    }

    public League getLeague() {
        return league;
    }

    public Set<Team> getTeams() {
        return teams;
    }
}
