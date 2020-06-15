package babble.services.roster.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

public class Roster {

    String race;

    String teamName;

    String coachName;

    Map<Integer, RosterPlayer> players;

    int rerolls;

    int fanFactor;

    int assistantCoaches;

    int cheerleaders;

    int apothecary;

    int treasury;

    int teamValue;

    // TODO BB2016 extras - sponsors, stadium, etc

    // TODO Constructors instead of setters?
    public String getRace() {
        return race;
    }

    public Roster setRace(final String race) {
        this.race = race;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Roster setTeamName(final String teamName) {
        this.teamName = teamName;
        return this;
    }

    public String getCoachName() {
        return coachName;
    }

    public Roster setCoachName(final String coachName) {
        this.coachName = coachName;
        return this;
    }

    public Map<Integer, RosterPlayer> getPlayersByJersey() {
        return players;
    }

    public Roster setPlayers(final Map<Integer, RosterPlayer> players) {
        this.players = players;
        return this;
    }

    public int getRerolls() {
        return rerolls;
    }

    public Roster setRerolls(final int rerolls) {
        this.rerolls = rerolls;
        return this;
    }

    public int getFanFactor() {
        return fanFactor;
    }

    public Roster setFanFactor(final int fanFactor) {
        this.fanFactor = fanFactor;
        return this;
    }

    public int getAssistantCoaches() {
        return assistantCoaches;
    }

    public Roster setAssistantCoaches(final int assistantCoaches) {
        this.assistantCoaches = assistantCoaches;
        return this;
    }

    public int getCheerleaders() {
        return cheerleaders;
    }

    public Roster setCheerleaders(final int cheerleaders) {
        this.cheerleaders = cheerleaders;
        return this;
    }

    public int getApothecary() {
        return apothecary;
    }

    public Roster setApothecary(final int apothecary) {
        this.apothecary = apothecary;
        return this;
    }

    public int getTreasury() {
        return treasury;
    }

    public Roster setTreasury(final int treasury) {
        this.treasury = treasury;
        return this;
    }

    public int getTeamValue() {
        return teamValue;
    }

    public Roster setTeamValue(final int teamValue) {
        this.teamValue = teamValue;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("race", race)
                .append("teamName", teamName)
                .append("coachName", coachName)
                .append("players", players)
                .append("rerolls", rerolls)
                .append("fanFactor", fanFactor)
                .append("assistantCoaches", assistantCoaches)
                .append("cheerleaders", cheerleaders)
                .append("apothecary", apothecary)
                .append("treasury", treasury)
                .append("teamValue", teamValue)
                .toString();
    }
}
