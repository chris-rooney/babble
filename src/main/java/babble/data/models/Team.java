package babble.data.models;

import babble.data.models.gamerules.Race;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long teamId;

    @Column(name = "coach_id")
    private Long coachUserId;

    @Column(name = "league_id")
    private Long leagueId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private League league;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private User coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Race race;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<TeamState> teamHistory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Player> players;

    // Seasons played
    @ManyToMany(mappedBy = "teams")
    private Set<Season> seasons;

    // For Hibernate
    protected Team() {
    }

    public Team(final Long coachUserId, final Long leagueId, final Long raceId, final String teamName) {
        this.coachUserId = coachUserId;
        this.leagueId = leagueId;
        this.raceId = raceId;
        this.teamName = teamName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Long getCoachUserId() {
        return coachUserId;
    }

    public Team setCoachUserId(final Long coachUserId) {
        this.coachUserId = coachUserId;
        return this;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public Team setLeagueId(final Long leagueId) {
        this.leagueId = leagueId;
        return this;
    }

    public Long getRaceId() {
        return raceId;
    }

    public Team setRaceId(final Long raceId) {
        this.raceId = raceId;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(final String teamName) {
        this.teamName = teamName;
        return this;
    }

    public League getLeague() {
        return league;
    }

    public User getCoach() {
        return coach;
    }

    public Race getRace() {
        return race;
    }

    public Set<TeamState> getTeamHistory() {
        return teamHistory;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }
}
