package babble.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long playerId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "jersey")
    private int jersey;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Team team;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    private Set<PlayerState> playerHistory;

    public Long getPlayerId() {
        return playerId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Player setTeamId(final Long teamId) {
        this.teamId = teamId;
        return this;
    }

    public Long getPositionId() {
        return positionId;
    }

    public Player setPositionId(final Long positionId) {
        this.positionId = positionId;
        return this;
    }

    public int getJersey() {
        return jersey;
    }

    public Player setJersey(final int jersey) {
        this.jersey = jersey;
        return this;
    }

    public String getName() {
        return name;
    }

    public Player setName(final String name) {
        this.name = name;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Player setActive(final boolean active) {
        this.active = active;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Set<PlayerState> getPlayerHistory() {
        return playerHistory;
    }
}
