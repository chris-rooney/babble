package babble.services.roster.data;

import babble.data.models.PlayerState;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RosterPlayer {

    private int number;
    private String name;
    private String position;

    private int movementAllowance;
    private int strength;
    private int agility;
    private int armorValue;

    private String skillsAndInjuries;

    private PlayerState.PlayerStatus status;

    private int completions;
    private int touchdowns;
    private int interceptions;
    private int casualties;
    private int mvps;
    private int totalSpps;
    private int value;

    // TODO Structure might vary by roster template
    private String skill1;

    private String skill2;

    private String skill3;

    private String skill4;

    private String skill5;

    private String skill6;

    private String injuries;

    public int getNumber() {
        return number;
    }

    public RosterPlayer setNumber(final int number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public RosterPlayer setName(final String name) {
        this.name = name;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public RosterPlayer setPosition(final String position) {
        this.position = position;
        return this;
    }

    public int getMovementAllowance() {
        return movementAllowance;
    }

    public RosterPlayer setMovementAllowance(final int movementAllowance) {
        this.movementAllowance = movementAllowance;
        return this;
    }

    public int getStrength() {
        return strength;
    }

    public RosterPlayer setStrength(final int strength) {
        this.strength = strength;
        return this;
    }

    public int getAgility() {
        return agility;
    }

    public RosterPlayer setAgility(final int agility) {
        this.agility = agility;
        return this;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public RosterPlayer setArmorValue(final int armorValue) {
        this.armorValue = armorValue;
        return this;
    }

    public String getSkillsAndInjuries() {
        return skillsAndInjuries;
    }

    public RosterPlayer setSkillsAndInjuries(final String skillsAndInjuries) {
        this.skillsAndInjuries = skillsAndInjuries;
        return this;
    }

    public PlayerState.PlayerStatus getStatus() {
        return status;
    }

    public RosterPlayer setStatus(final PlayerState.PlayerStatus status) {
        this.status = status;
        return this;
    }

    public int getCompletions() {
        return completions;
    }

    public RosterPlayer setCompletions(final int completions) {
        this.completions = completions;
        return this;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public RosterPlayer setTouchdowns(final int touchdowns) {
        this.touchdowns = touchdowns;
        return this;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public RosterPlayer setInterceptions(final int interceptions) {
        this.interceptions = interceptions;
        return this;
    }

    public int getCasualties() {
        return casualties;
    }

    public RosterPlayer setCasualties(final int casualties) {
        this.casualties = casualties;
        return this;
    }

    public int getMvps() {
        return mvps;
    }

    public RosterPlayer setMvps(final int mvps) {
        this.mvps = mvps;
        return this;
    }

    public int getTotalSpps() {
        return totalSpps;
    }

    public RosterPlayer setTotalSpps(final int totalSpps) {
        this.totalSpps = totalSpps;
        return this;
    }

    public int getValue() {
        return value;
    }

    public RosterPlayer setValue(final int value) {
        this.value = value;
        return this;
    }

    public String getSkill1() {
        return skill1;
    }

    public RosterPlayer setSkill1(final String skill1) {
        this.skill1 = skill1;
        return this;
    }

    public String getSkill2() {
        return skill2;
    }

    public RosterPlayer setSkill2(final String skill2) {
        this.skill2 = skill2;
        return this;
    }

    public String getSkill3() {
        return skill3;
    }

    public RosterPlayer setSkill3(final String skill3) {
        this.skill3 = skill3;
        return this;
    }

    public String getSkill4() {
        return skill4;
    }

    public RosterPlayer setSkill4(final String skill4) {
        this.skill4 = skill4;
        return this;
    }

    public String getSkill5() {
        return skill5;
    }

    public RosterPlayer setSkill5(final String skill5) {
        this.skill5 = skill5;
        return this;
    }

    public String getSkill6() {
        return skill6;
    }

    public RosterPlayer setSkill6(final String skill6) {
        this.skill6 = skill6;
        return this;
    }

    public String getInjuries() {
        return injuries;
    }

    public RosterPlayer setInjuries(final String injuries) {
        this.injuries = injuries;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("number", number)
                .append("name", name)
                .append("position", position)
                .append("movementAllowance", movementAllowance)
                .append("strength", strength)
                .append("agility", agility)
                .append("armorValue", armorValue)
                .append("skillsAndInjuries", skillsAndInjuries)
                .append("status", status)
                .append("completions", completions)
                .append("touchdowns", touchdowns)
                .append("interceptions", interceptions)
                .append("casualties", casualties)
                .append("mvps", mvps)
                .append("totalSpps", totalSpps)
                .append("value", value)
                .append("skill1", skill1)
                .append("skill2", skill2)
                .append("skill3", skill3)
                .append("skill4", skill4)
                .append("skill5", skill5)
                .append("skill6", skill6)
                .append("injuries", injuries)
                .toString();
    }
}
