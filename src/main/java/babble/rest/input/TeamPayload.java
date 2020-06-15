package babble.rest.input;

public class TeamPayload {

    private long coachUserId;
    private long leagueId;
    private long raceId;
    private String teamName;

    public TeamPayload() {
    }

    public long getCoachUserId() {
        return coachUserId;
    }

    public void setCoachUserId(final long coachUserId) {
        this.coachUserId = coachUserId;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(final long leagueId) {
        this.leagueId = leagueId;
    }

    public long getRaceId() {
        return raceId;
    }

    public void setRaceId(final long raceId) {
        this.raceId = raceId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(final String teamName) {
        this.teamName = teamName;
    }
}
