

package babble.services.output;

import babble.services.output.rules.RaceDto;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.lang.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TeamDto extends TeamDto {

  private final long id;
  private final String name;
  private final UserDto coach;
  private final RaceDto race;
  private final List<PlayerDto> players;

  private AutoValue_TeamDto(
      long id,
      String name,
      @Nullable UserDto coach,
      @Nullable RaceDto race,
      List<PlayerDto> players) {
    this.id = id;
    this.name = name;
    this.coach = coach;
    this.race = race;
    this.players = players;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Nullable
  @Override
  public UserDto getCoach() {
    return coach;
  }

  @Nullable
  @Override
  public RaceDto getRace() {
    return race;
  }

  @Override
  public List<PlayerDto> getPlayers() {
    return players;
  }

  @Override
  public String toString() {
    return "TeamDto{"
         + "id=" + id + ", "
         + "name=" + name + ", "
         + "coach=" + coach + ", "
         + "race=" + race + ", "
         + "players=" + players
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TeamDto) {
      TeamDto that = (TeamDto) o;
      return (this.id == that.getId())
           && (this.name.equals(that.getName()))
           && ((this.coach == null) ? (that.getCoach() == null) : this.coach.equals(that.getCoach()))
           && ((this.race == null) ? (that.getRace() == null) : this.race.equals(that.getRace()))
           && (this.players.equals(that.getPlayers()));
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
    h$ ^= (coach == null) ? 0 : coach.hashCode();
    h$ *= 1000003;
    h$ ^= (race == null) ? 0 : race.hashCode();
    h$ *= 1000003;
    h$ ^= players.hashCode();
    return h$;
  }

  static final class Builder extends TeamDto.Builder {
    private Long id;
    private String name;
    private UserDto coach;
    private RaceDto race;
    private List<PlayerDto> players;
    Builder() {
    }
    @Override
    public TeamDto.Builder setId(long id) {
      this.id = id;
      return this;
    }
    @Override
    public TeamDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public TeamDto.Builder setCoach(@Nullable UserDto coach) {
      this.coach = coach;
      return this;
    }
    @Override
    public TeamDto.Builder setRace(@Nullable RaceDto race) {
      this.race = race;
      return this;
    }
    @Override
    public TeamDto.Builder setPlayers(List<PlayerDto> players) {
      if (players == null) {
        throw new NullPointerException("Null players");
      }
      this.players = players;
      return this;
    }
    @Override
    public TeamDto build() {
      String missing = "";
      if (this.id == null) {
        missing += " id";
      }
      if (this.name == null) {
        missing += " name";
      }
      if (this.players == null) {
        missing += " players";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_TeamDto(
          this.id,
          this.name,
          this.coach,
          this.race,
          this.players);
    }
  }

}
