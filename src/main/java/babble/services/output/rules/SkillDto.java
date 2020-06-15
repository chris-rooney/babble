package babble.services.output.rules;

import com.google.auto.value.AutoValue;

// TODO Kind of overkill with just the skill name right now, planning to add more later
@AutoValue
public abstract class SkillDto {

    public static Builder newBuilder() {
        return new AutoValue_SkillDto.Builder();
    }

    public abstract String getName();

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setName(String name);

        public abstract SkillDto build();
    }
}
