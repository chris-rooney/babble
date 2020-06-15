

package babble.services.output.rules;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SkillDto extends SkillDto {

  private final String name;

  private AutoValue_SkillDto(
      String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "SkillDto{"
         + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SkillDto) {
      SkillDto that = (SkillDto) o;
      return (this.name.equals(that.getName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= name.hashCode();
    return h$;
  }

  static final class Builder extends SkillDto.Builder {
    private String name;
    Builder() {
    }
    @Override
    public SkillDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public SkillDto build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SkillDto(
          this.name);
    }
  }

}
