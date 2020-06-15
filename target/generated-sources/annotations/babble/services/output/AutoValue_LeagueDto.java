

package babble.services.output;

import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_LeagueDto extends LeagueDto {

  private final long id;
  private final String name;
  private final List<SeasonDto> seasons;
  private final List<UserDto> coaches;

  private AutoValue_LeagueDto(
      long id,
      String name,
      List<SeasonDto> seasons,
      List<UserDto> coaches) {
    this.id = id;
    this.name = name;
    this.seasons = seasons;
    this.coaches = coaches;
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
  public List<SeasonDto> getSeasons() {
    return seasons;
  }

  @Override
  public List<UserDto> getCoaches() {
    return coaches;
  }

  @Override
  public String toString() {
    return "LeagueDto{"
         + "id=" + id + ", "
         + "name=" + name + ", "
         + "seasons=" + seasons + ", "
         + "coaches=" + coaches
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LeagueDto) {
      LeagueDto that = (LeagueDto) o;
      return (this.id == that.getId())
           && (this.name.equals(that.getName()))
           && (this.seasons.equals(that.getSeasons()))
           && (this.coaches.equals(that.getCoaches()));
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
    h$ ^= seasons.hashCode();
    h$ *= 1000003;
    h$ ^= coaches.hashCode();
    return h$;
  }

  static final class Builder extends LeagueDto.Builder {
    private Long id;
    private String name;
    private List<SeasonDto> seasons;
    private List<UserDto> coaches;
    Builder() {
    }
    @Override
    public LeagueDto.Builder setId(long id) {
      this.id = id;
      return this;
    }
    @Override
    public LeagueDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public LeagueDto.Builder setSeasons(List<SeasonDto> seasons) {
      if (seasons == null) {
        throw new NullPointerException("Null seasons");
      }
      this.seasons = seasons;
      return this;
    }
    @Override
    public LeagueDto.Builder setCoaches(List<UserDto> coaches) {
      if (coaches == null) {
        throw new NullPointerException("Null coaches");
      }
      this.coaches = coaches;
      return this;
    }
    @Override
    public LeagueDto build() {
      String missing = "";
      if (this.id == null) {
        missing += " id";
      }
      if (this.name == null) {
        missing += " name";
      }
      if (this.seasons == null) {
        missing += " seasons";
      }
      if (this.coaches == null) {
        missing += " coaches";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_LeagueDto(
          this.id,
          this.name,
          this.seasons,
          this.coaches);
    }
  }

}
