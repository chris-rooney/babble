package babble.data.models;

import babble.data.models.gamerules.Injury;
import babble.data.models.gamerules.Skill;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player_state")
public class PlayerState {

    public enum PlayerStatus {
        HEALTHY, MISS_NEXT_GAME, JOURNEYMAN, UNKNOWN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long playerStateId;

    // TODO Can mandatory FKs be primitives?
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "team_state_id")
    private Long teamStateId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PlayerStatus status;

    @Column(name = "completions")
    private int completions;

    @Column(name = "touchdowns")
    private int touchdowns;

    @Column(name = "interceptions")
    private int interceptions;

    @Column(name = "casualties")
    private int casualties;

    @Column(name = "mvps")
    private int mvps;

    @Column(name = "value")
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_state_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private TeamState teamState;

    @ManyToMany
    @JoinTable(name = "player_skill", joinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "player_state_id", referencedColumnName = "id")})
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name = "player_injury", joinColumns = {@JoinColumn(name = "injury_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "player_state_id", referencedColumnName = "id")})
    private Set<Injury> injuries;

    // For Hibernate
    protected PlayerState() {
    }

    public PlayerState(final Long playerId, final Long teamStateId, final PlayerStatus status, final int completions, final int touchdowns, final int interceptions, final int casualties, final int mvps, final int value) {
        this.playerId = playerId;
        this.teamStateId = teamStateId;
        this.status = status;
        this.completions = completions;
        this.touchdowns = touchdowns;
        this.interceptions = interceptions;
        this.casualties = casualties;
        this.mvps = mvps;
        this.value = value;
        this.skills = new HashSet<>();
        this.injuries = new HashSet<>();
    }

    public Long getPlayerStateId() {
        return playerStateId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Long getTeamStateId() {
        return teamStateId;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public int getCompletions() {
        return completions;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public int getCasualties() {
        return casualties;
    }

    public int getMvps() {
        return mvps;
    }

    public int getValue() {
        return value;
    }

    public Player getPlayer() {
        return player;
    }

    public TeamState getTeamState() {
        return teamState;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public Set<Injury> getInjuries() {
        return injuries;
    }
}
