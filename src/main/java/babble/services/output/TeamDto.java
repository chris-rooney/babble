package babble.services.output;

import babble.services.output.rules.RaceDto;
import com.google.auto.value.AutoValue;
import org.springframework.lang.Nullable;

import java.util.List;

@AutoValue
public abstract class TeamDto {

    public static Builder newBuilder() {
        return new AutoValue_TeamDto.Builder();
    }

    public abstract long getId();

    public abstract String getName();

    @Nullable
    public abstract UserDto getCoach();

    @Nullable
    public abstract RaceDto getRace();

    public abstract List<PlayerDto> getPlayers();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setId(long id);

        public abstract Builder setName(String name);

        public abstract Builder setCoach(UserDto coach);

        public abstract Builder setRace(RaceDto race);

        public abstract Builder setPlayers(List<PlayerDto> players);

        public abstract TeamDto build();
    }
}
