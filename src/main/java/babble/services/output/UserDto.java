package babble.services.output;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class UserDto {

    public static Builder newBuilder() {
        return new AutoValue_UserDto.Builder();
    }

    public abstract long getId();

    public abstract String getUsername();

    public abstract String getFirstName();

    public abstract String getLastName();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setId(long id);

        public abstract Builder setUsername(String username);

        public abstract Builder setFirstName(String firstName);

        public abstract Builder setLastName(String lastName);

        public abstract UserDto build();
    }
}
