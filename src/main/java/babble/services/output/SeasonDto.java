package babble.services.output;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class SeasonDto {

    public static Builder newBuilder() {
        return new AutoValue_SeasonDto.Builder();
    }

    public abstract long getId();

    public abstract String getName();

    public abstract long getLeagueId();

    public abstract List<TeamDto> getTeams();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setId(long id);

        public abstract Builder setName(String name);

        public abstract Builder setLeagueId(long leagueId);

        public abstract Builder setTeams(List<TeamDto> teams);

        public abstract SeasonDto build();
    }
}
