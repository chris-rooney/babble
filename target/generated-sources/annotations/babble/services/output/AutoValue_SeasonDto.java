

package babble.services.output;

import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SeasonDto extends SeasonDto {

  private final long id;
  private final String name;
  private final long leagueId;
  private final List<TeamDto> teams;

  private AutoValue_SeasonDto(
      long id,
      String name,
      long leagueId,
      List<TeamDto> teams) {
    this.id = id;
    this.name = name;
    this.leagueId = leagueId;
    this.teams = teams;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public long getLeagueId() {
    return leagueId;
  }

  @Override
  public List<TeamDto> getTeams() {
    return teams;
  }

  @Override
  public String toString() {
    return "SeasonDto{"
         + "id=" + id + ", "
         + "name=" + name + ", "
         + "leagueId=" + leagueId + ", "
         + "teams=" + teams
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SeasonDto) {
      SeasonDto that = (SeasonDto) o;
      return (this.id == that.getId())
           && (this.name.equals(that.getName()))
           && (this.leagueId == that.getLeagueId())
           && (this.teams.equals(that.getTeams()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (int) ((id >>> 32) ^ id);
    h$ *= 1000003;
    h$ ^= name.hashCode();
    h$ *= 1000003;
    h$ ^= (int) ((leagueId >>> 32) ^ leagueId);
    h$ *= 1000003;
    h$ ^= teams.hashCode();
    return h$;
  }

  static final class Builder extends SeasonDto.Builder {
    private Long id;
    private String name;
    private Long leagueId;
    private List<TeamDto> teams;
    Builder() {
    }
    @Override
    public SeasonDto.Builder setId(long id) {
      this.id = id;
      return this;
    }
    @Override
    public SeasonDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public SeasonDto.Builder setLeagueId(long leagueId) {
      this.leagueId = leagueId;
      return this;
    }
    @Override
    public SeasonDto.Builder setTeams(List<TeamDto> teams) {
      if (teams == null) {
        throw new NullPointerException("Null teams");
      }
      this.teams = teams;
      return this;
    }
    @Override
    public SeasonDto build() {
      String missing = "";
      if (this.id == null) {
        missing += " id";
      }
      if (this.name == null) {
        missing += " name";
      }
      if (this.leagueId == null) {
        missing += " leagueId";
      }
      if (this.teams == null) {
        missing += " teams";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SeasonDto(
          this.id,
          this.name,
          this.leagueId,
          this.teams);
    }
  }

}
