package babble.services.output;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class LeagueDto {

    public static Builder newBuilder() {
        return new AutoValue_LeagueDto.Builder();
    }

    public abstract long getId();

    public abstract String getName();

    public abstract List<SeasonDto> getSeasons();

    public abstract List<UserDto> getCoaches();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setId(long id);

        public abstract Builder setName(String name);

        public abstract Builder setSeasons(List<SeasonDto> seasons);

        public abstract Builder setCoaches(List<UserDto> coaches);

        public abstract LeagueDto build();
    }
}
