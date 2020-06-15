package babble.services.output;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PlayerDto {

    public static Builder newBuilder() {
        return new AutoValue_PlayerDto.Builder();
    }

    // TODO Flesh out
    public abstract String getName();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setName(String name);

        public abstract PlayerDto build();
    }
}
