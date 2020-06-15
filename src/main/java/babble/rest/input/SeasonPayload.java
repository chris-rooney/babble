package babble.rest.input;

public class SeasonPayload {

    private String name;
    private long leagueId;

    public SeasonPayload() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(final long leagueId) {
        this.leagueId = leagueId;
    }
}
