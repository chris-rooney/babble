

package babble.services.output.rules;

import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RaceDto extends RaceDto {

  private final long id;
  private final String name;
  private final int rerollCost;
  private final List<PositionDto> positions;

  private AutoValue_RaceDto(
      long id,
      String name,
      int rerollCost,
      List<PositionDto> positions) {
    this.id = id;
    this.name = name;
    this.rerollCost = rerollCost;
    this.positions = positions;
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
  public int getRerollCost() {
    return rerollCost;
  }

  @Override
  public List<PositionDto> getPositions() {
    return positions;
  }

  @Override
  public String toString() {
    return "RaceDto{"
         + "id=" + id + ", "
         + "name=" + name + ", "
         + "rerollCost=" + rerollCost + ", "
         + "positions=" + positions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RaceDto) {
      RaceDto that = (RaceDto) o;
      return (this.id == that.getId())
           && (this.name.equals(that.getName()))
           && (this.rerollCost == that.getRerollCost())
           && (this.positions.equals(that.getPositions()));
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
    h$ ^= rerollCost;
    h$ *= 1000003;
    h$ ^= positions.hashCode();
    return h$;
  }

  static final class Builder extends RaceDto.Builder {
    private Long id;
    private String name;
    private Integer rerollCost;
    private List<PositionDto> positions;
    Builder() {
    }
    @Override
    public RaceDto.Builder setId(long id) {
      this.id = id;
      return this;
    }
    @Override
    public RaceDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public RaceDto.Builder setRerollCost(int rerollCost) {
      this.rerollCost = rerollCost;
      return this;
    }
    @Override
    public RaceDto.Builder setPositions(List<PositionDto> positions) {
      if (positions == null) {
        throw new NullPointerException("Null positions");
      }
      this.positions = positions;
      return this;
    }
    @Override
    public RaceDto build() {
      String missing = "";
      if (this.id == null) {
        missing += " id";
      }
      if (this.name == null) {
        missing += " name";
      }
      if (this.rerollCost == null) {
        missing += " rerollCost";
      }
      if (this.positions == null) {
        missing += " positions";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_RaceDto(
          this.id,
          this.name,
          this.rerollCost,
          this.positions);
    }
  }

}
