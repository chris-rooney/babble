package babble.services.output.rules;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class PositionDto {

    public static Builder newBuilder() {
        return new AutoValue_PositionDto.Builder();
    }

    public abstract String getName();

    public abstract int getMax();

    public abstract int getBaseMovement();

    public abstract int getBaseStrength();

    public abstract int getBaseAgility();

    public abstract int getBaseArmor();

    public abstract int getBaseValue();

    public abstract String getNormalSkillCategories();

    public abstract String getDoublesSkillCategories();

    public abstract List<SkillDto> getStartingSkills();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setName(String name);

        public abstract Builder setMax(int max);

        public abstract Builder setBaseMovement(int baseMovement);

        public abstract Builder setBaseStrength(int baseStrength);

        public abstract Builder setBaseAgility(int baseAgility);

        public abstract Builder setBaseArmor(int baseArmor);

        public abstract Builder setBaseValue(int baseValue);

        public abstract Builder setNormalSkillCategories(String normalSkillCategories);

        public abstract Builder setDoublesSkillCategories(String doublesSkillCategories);

        public abstract Builder setStartingSkills(List<SkillDto> startingSkills);

        public abstract PositionDto build();
    }
}
