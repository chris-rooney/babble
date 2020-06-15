package babble.data.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team_state")
public class TeamState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long teamStateId;

    @Column(name = "team_id")
    private Long teamId;

    // TODO "As-of" data - likely a "Match" table link

    @Column(name = "rerolls")
    private int rerolls;

    @Column(name = "fan_factor")
    private int fanFactor;

    @Column(name = "assistant_coaches")
    private int assistantCoaches;

    @Column(name = "cheerleaders")
    private int cheerleaders;

    @Column(name = "has_apothecary")
    private boolean hasApothecary;

    @Column(name = "treasury")
    private int treasury;

    // Current players on the team roster
    @ManyToMany(mappedBy = "teamState")
    private Set<PlayerState> players;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Team team;

    // Permanent inducements, Sponsors, Stadium, other random shit

    // For Hibernate
    protected TeamState() {
    }

    public TeamState(final Long teamId, final int rerolls, final int fanFactor, final int assistantCoaches, final int cheerleaders, final boolean hasApothecary, final int treasury) {
        this.teamId = teamId;
        this.rerolls = rerolls;
        this.fanFactor = fanFactor;
        this.assistantCoaches = assistantCoaches;
        this.cheerleaders = cheerleaders;
        this.hasApothecary = hasApothecary;
        this.treasury = treasury;
    }

    public Long getTeamStateId() {
        return teamStateId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public int getRerolls() {
        return rerolls;
    }

    public int getFanFactor() {
        return fanFactor;
    }

    public int getAssistantCoaches() {
        return assistantCoaches;
    }

    public int getCheerleaders() {
        return cheerleaders;
    }

    public boolean isHasApothecary() {
        return hasApothecary;
    }

    public int getTreasury() {
        return treasury;
    }

    public Set<PlayerState> getPlayers() {
        return players;
    }
}
