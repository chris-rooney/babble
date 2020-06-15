

package babble.services.output;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_PlayerDto extends PlayerDto {

  private final String name;

  private AutoValue_PlayerDto(
      String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "PlayerDto{"
         + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PlayerDto) {
      PlayerDto that = (PlayerDto) o;
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

  static final class Builder extends PlayerDto.Builder {
    private String name;
    Builder() {
    }
    @Override
    public PlayerDto.Builder setName(String name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public PlayerDto build() {
      String missing = "";
      if (this.name == null) {
        missing += " name";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_PlayerDto(
          this.name);
    }
  }

}
