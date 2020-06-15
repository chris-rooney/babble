package babble.services;

import babble.data.access.rules.PositionRepository;
import babble.data.access.rules.RaceRepository;
import babble.data.models.gamerules.Position;
import babble.data.models.gamerules.Race;
import babble.data.models.gamerules.Skill;
import babble.services.output.rules.PositionDto;
import babble.services.output.rules.RaceDto;
import babble.services.output.rules.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RulesService {

    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private PositionRepository positionRepository;

    public List<RaceDto> getRaces() {
        return raceRepository.findAll().stream()
                .map(RulesService::raceToDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public RaceDto getRaceById(final long id) {
        return raceToDto(raceRepository.findById(id).orElse(null));
    }

    public List<PositionDto> getPositionsForRace(final long raceId) {
        return positionRepository.findByRaceId(raceId).stream()
                .map(RulesService::positionToDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static RaceDto raceToDto(final Race race) {
        if (race == null) {
            return null;
        }
        return RaceDto.newBuilder()
                .setId(race.getId())
                .setName(race.getName())
                .setRerollCost(race.getRerollCost())
                .setPositions(race.getPositions().stream()
                        .map(RulesService::positionToDto)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .build();
    }

    public static PositionDto positionToDto(final Position position) {
        if (position == null) {
            return null;
        }
        return PositionDto.newBuilder()
                .setName(position.getName())
                .setMax(position.getMax())
                .setBaseMovement(position.getBaseMovement())
                .setBaseStrength(position.getBaseStrength())
                .setBaseAgility(position.getBaseAgility())
                .setBaseArmor(position.getBaseArmor())
                .setBaseValue(position.getBaseValue())
                .setNormalSkillCategories(position.getNormalSkillCategories())
                .setDoublesSkillCategories(position.getDoublesSkillCategories())
                .setStartingSkills(position.getSkills().stream()
                        .map(RulesService::skillToDto)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .build();
    }

    public static SkillDto skillToDto(final Skill skill) {
        if (skill == null) {
            return null;
        }
        return SkillDto.newBuilder()
                .setName(skill.getName())
                .build();
    }
}
