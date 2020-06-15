

package babble.services.output;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UserDto extends UserDto {

  private final long id;
  private final String username;
  private final String firstName;
  private final String lastName;

  private AutoValue_UserDto(
      long id,
      String username,
      String firstName,
      String lastName) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return "UserDto{"
         + "id=" + id + ", "
         + "username=" + username + ", "
         + "firstName=" + firstName + ", "
         + "lastName=" + lastName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UserDto) {
      UserDto that = (UserDto) o;
      return (this.id == that.getId())
           && (this.username.equals(that.getUsername()))
           && (this.firstName.equals(that.getFirstName()))
           && (this.lastName.equals(that.getLastName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (int) ((id >>> 32) ^ id);
    h$ *= 1000003;
    h$ ^= username.hashCode();
    h$ *= 1000003;
    h$ ^= firstName.hashCode();
    h$ *= 1000003;
    h$ ^= lastName.hashCode();
    return h$;
  }

  static final class Builder extends UserDto.Builder {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    Builder() {
    }
    @Override
    public UserDto.Builder setId(long id) {
      this.id = id;
      return this;
    }
    @Override
    public UserDto.Builder setUsername(String username) {
      if (username == null) {
        throw new NullPointerException("Null username");
      }
      this.username = username;
      return this;
    }
    @Override
    public UserDto.Builder setFirstName(String firstName) {
      if (firstName == null) {
        throw new NullPointerException("Null firstName");
      }
      this.firstName = firstName;
      return this;
    }
    @Override
    public UserDto.Builder setLastName(String lastName) {
      if (lastName == null) {
        throw new NullPointerException("Null lastName");
      }
      this.lastName = lastName;
      return this;
    }
    @Override
    public UserDto build() {
      String missing = "";
      if (this.id == null) {
        missing += " id";
      }
      if (this.username == null) {
        missing += " username";
      }
      if (this.firstName == null) {
        missing += " firstName";
      }
      if (this.lastName == null) {
        missing += " lastName";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_UserDto(
          this.id,
          this.username,
          this.firstName,
          this.lastName);
    }
  }

}
