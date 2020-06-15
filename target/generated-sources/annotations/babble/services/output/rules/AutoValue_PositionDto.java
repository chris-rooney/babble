

package babble.services.output.rules;

import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_PositionDto extends PositionDto {

  private final String name;
  private final int max;
  private final int baseMovement;
  private final int baseStrength;
  private final int baseAgility;
  private final int baseArmor;
  private final int baseValue;
  private final String normalSkillCategories;
  private final String doublesSkillCategories;
  private final List<SkillDto> startingSkills;

  private AutoValue_PositionDto(
      String name,
      int max,
      int baseMovement,
      int baseStrength,
      int baseAgility,
      int baseArmor,
      int baseValue,
      String normalSkillCategories,
      String doublesSkillCategories,
      List<SkillDto> startingSkills) {
    this.name = name;
    this.max = max;
    this.baseMovement = baseMovement;
    this.baseStrength = baseStrength;
    this.baseAgility = baseAgility;
    this.baseArmor = baseArmor;
    this.baseValue = baseValue;
    this.normalSkillCategories = normalSkillCategories;
    this.doublesSkillCategories = doublesSkillCategories;
    this.startingSkills = startingSkills;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getMax() {
    return max;
  }

  @Override
  public int getBaseMovement() {
    return baseMovement;
  }

  @Override
  public int getBaseStrength() {
    return baseStrength;
  }

  @Override
  public int getBaseAgility() {
    return baseAgility;
  }

  @Override
  public int getBaseArmor() {
    return baseArmor;
  }

  @Override
  public int getBaseValue() {
    return baseValue;
  }

  @Override
  public String getNormalSkillCategories() {
    return normalSkillCategories;
  }

  @Override
  public String getDoublesSkillCategories() {
    return doublesSkillCategories;
  }

  @Override
  public List<SkillDto> getStartingSkills() {
    return startingSkills;
  }

  @Override
  public String toString() {
    return "PositionDto{"
         + "name=" + name + ", "
         + "max=" + max + ", "
         + "baseMovement=" + baseMovement + ", "
         + "baseStrength=" + baseStrength + ", "
         + "baseAgility=" + baseAgility + ", "
         + "baseArmor=" + baseArmor + ", "
         + "baseValue=" + baseValue + ", "
         + "normalSkillCategories=" + normalSkillCategories + ", "
         + "doublesSkillCategories=" + doublesSkillCategories + ", "
         + "startingSkills=" + startingSkills
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PositionDto) {
      PositionDto that = (PositionDto) o;
      return (this.name.equals(that.getName()))
           && (this.max == that.getMax())
           && (this.baseMovement == that.getBaseMovement())
           && (this.baseStrength == that.getBaseStrength())
           && (this.baseAgility == that.getBaseAgility())
           && (this.baseArmor == that.getBaseArmor())
           && (this.baseValue == that.getBaseValue())
           && (this.normalSkillCategories.equals(that.getNormalSkillCategories()))
           && (this.doublesSkillCategories.equals(that.getDoublesSkillCategories()))
           && (this.startingSkills.equals(that.getStartingSkills()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= name.hashCode();
    h$ *= 1000003;
    h$ ^= max;
    h$ *= 1000003;
    h$ ^= baseMovement;
    h$ *= 1000003;
    h$ ^= baseStrength;
    h$ *= 1000003;
    h$ ^= baseAgility;
    h$ *= 1000003;
    h$ ^= baseArmor;
    h$ *= 1000003;
    h$ ^= baseValue;
    h$ *= 1000003;
    h$ ^= normalSkillCategories.hashCode();
    h$ *= 1000003;
    h$ ^= doublesSkillCategories.hashCode();
    h$ *= 1000003;
    h$ ^= startingSkills.hashCode();
    return h$;
  }

  static final class Builder extends PositionDto.Builder {
    private String name;
    private Integer max;
    private Integer baseMovement;
    private Integer baseStrength;
    private Integer baseAgility;
    private Integer baseArmor;
    private Integer baseValue;
    private String normalSkillCategories;
    private String doublesSkillCategories;
    private List<SkillDto> startingSkills;
    Builder() {
    }
    @Override
    public PositionDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public PositionDto.Builder setMax(int max) {
      this.max = max;
      return this;
    }
    @Override
    public PositionDto.Builder setBaseMovement(int baseMovement) {
      this.baseMovement = baseMovement;
      return this;
    }
    @Override
    public PositionDto.Builder setBaseStrength(int baseStrength) {
      this.baseStrength = baseStrength;
      return this;
    }
    @Override
    public PositionDto.Builder setBaseAgility(int baseAgility) {
      this.baseAgility = baseAgility;
      return this;
    }
    @Override
    public PositionDto.Builder setBaseArmor(int baseArmor) {
      this.baseArmor = baseArmor;
      return this;
    }
    @Override
    public PositionDto.Builder setBaseValue(int baseValue) {
      this.baseValue = baseValue;
      return this;
    }
    @Override
    public PositionDto.Builder setNormalSkillCategories(String normalSkillCategories) {
      if (normalSkillCategories == null) {
        throw new NullPointerException("Null normalSkillCategories");
      }
      this.normalSkillCategories = normalSkillCategories;
      return this;
    }
    @Override
    public PositionDto.Builder setDoublesSkillCategories(String doublesSkillCategories) {
      if (doublesSkillCategories == null) {
        throw new NullPointerException("Null doublesSkillCategories");
      }
      this.doublesSkillCategories = doublesSkillCategories;
      return this;
    }
    @Override
    public PositionDto.Builder setStartingSkills(List<SkillDto> startingSkills) {
      if (startingSkills == null) {
        throw new NullPointerException("Null startingSkills");
      }
      this.startingSkills = startingSkills;
      return this;
    }
    @Override
    public PositionDto build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (this.max == null) {
        missing += " max";
      }
      if (this.baseMovement == null) {
        missing += " baseMovement";
      }
      if (this.baseStrength == null) {
        missing += " baseStrength";
      }
      if (this.baseAgility == null) {
        missing += " baseAgility";
      }
      if (this.baseArmor == null) {
        missing += " baseArmor";
      }
      if (this.baseValue == null) {
        missing += " baseValue";
      }
      if (this.normalSkillCategories == null) {
        missing += " normalSkillCategories";
      }
      if (this.doublesSkillCategories == null) {
        missing += " doublesSkillCategories";
      }
      if (this.startingSkills == null) {
        missing += " startingSkills";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_PositionDto(
          this.name,
          this.max,
          this.baseMovement,
          this.baseStrength,
          this.baseAgility,
          this.baseArmor,
          this.baseValue,
          this.normalSkillCategories,
          this.doublesSkillCategories,
          this.startingSkills);
    }
  }

}
