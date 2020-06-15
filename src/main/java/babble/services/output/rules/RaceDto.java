package babble.services.output.rules;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class RaceDto {

    public static Builder newBuilder() {
        return new AutoValue_RaceDto.Builder();
    }

    public abstract long getId();

    public abstract String getName();

    public abstract int getRerollCost();

    public abstract List<PositionDto> getPositions();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setId(long id);

        public abstract Builder setName(String name);

        public abstract Builder setRerollCost(int rerollCost);

        public abstract Builder setPositions(List<PositionDto> positions);

        public abstract RaceDto build();
    }
}
