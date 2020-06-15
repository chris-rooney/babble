package babble.services.roster.reader;

import babble.data.models.PlayerState;
import babble.services.roster.data.Roster;
import babble.services.roster.data.RosterPlayer;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HalfingScribeRosterReader implements RosterReader {

    private static final Logger logger = LoggerFactory.getLogger(HalfingScribeRosterReader.class);

    private static final String ROSTER_SHEET = "Team Sheet";

    private static final int COACH_NAME_ROW = 2;
    private static final int COACH_NAME_COLUMN = 13;
    private static final int TEAM_NAME_ROW = 2;
    private static final int TEAM_NAME_COLUMN = 9;
    private static final int RACE_NAME_ROW = 2;
    private static final int RACE_NAME_COLUMN = 13;

    private static final int PLAYER_START_ROW = 5;
    private static final int PLAYER_STOP_ROW = 20;
    private static final int PLAYER_NUMBER_COLUMN = 2;
    private static final int PLAYER_NAME_COLUMN = 3;
    private static final int PLAYER_POSITION_COLUMN = 4;
    private static final int PLAYER_MA_COLUMN = 6;
    private static final int PLAYER_ST_COLUMN = 7;
    private static final int PLAYER_AG_COLUMN = 8;
    private static final int PLAYER_AV_COLUMN = 9;
    private static final int PLAYER_SKILLS_AND_INJURIES_COLUMN = 10;
    private static final int PLAYER_STATUS_COLUMN = 11;
    private static final int PLAYER_CP_COLUMN = 12;
    private static final int PLAYER_TD_COLUMN = 13;
    private static final int PLAYER_IN_COLUMN = 14;
    private static final int PLAYER_CS_COLUMN = 15;
    private static final int PLAYER_MVP_COLUMN = 16;
    private static final int PLAYER_SPP_COLUMN = 17;
    private static final int PLAYER_VALUE_COLUMN = 18;

    private static final int REROLLS_ROW = 33;
    private static final int REROLLS_COLUMN = 12;
    private static final int FAN_FACTOR_ROW = 34;
    private static final int FAN_FACTOR_COLUMN = 12;
    private static final int ASSISTANT_COACHES_ROW = 35;
    private static final int ASSISTANT_COACHES_COLUMN = 12;
    private static final int CHEERLEADERS_ROW = 36;
    private static final int CHEERLEADERS_COLUMN = 12;
    private static final int APOTHECARY_ROW = 37;
    private static final int APOTHECARY_COLUMN = 12;
    private static final int TREASURY_ROW = 38;
    private static final int TREASURY_COLUMN = 12;
    private static final int TEAM_VALUE_ROW = 39;
    private static final int TEAM_VALUE_COLUMN = 17;

    private static final String MISS_NEXT_GAME = "MNG";
    private static final String JOURNEYMAN = "Journeyman";

    @Override
    public Roster readRoster(final Workbook rosterFile) {
        logger.info("Reading roster");
        final Sheet sheet = rosterFile.getSheet(ROSTER_SHEET);
        final Map<Integer, RosterPlayer> rosterPlayerData = IntStream.rangeClosed(PLAYER_START_ROW, PLAYER_STOP_ROW)
                .mapToObj(i -> readPlayerData(sheet.getRow(i)))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(RosterPlayer::getNumber, Function.identity()));
        return new Roster()
                .setCoachName(getStringAtCoordinates(sheet, COACH_NAME_ROW, COACH_NAME_COLUMN))
                .setTeamName(getStringAtCoordinates(sheet, TEAM_NAME_ROW, TEAM_NAME_COLUMN))
                .setRace(getStringAtCoordinates(sheet, RACE_NAME_ROW, RACE_NAME_COLUMN))
                .setPlayers(rosterPlayerData)
                .setRerolls(getIntValueAtCoordinates(sheet, REROLLS_ROW, REROLLS_COLUMN))
                .setFanFactor(getIntValueAtCoordinates(sheet, FAN_FACTOR_ROW, FAN_FACTOR_COLUMN))
                .setAssistantCoaches(getIntValueAtCoordinates(sheet, ASSISTANT_COACHES_ROW, ASSISTANT_COACHES_COLUMN))
                .setCheerleaders(getIntValueAtCoordinates(sheet, CHEERLEADERS_ROW, CHEERLEADERS_COLUMN))
                .setApothecary(getIntValueAtCoordinates(sheet, APOTHECARY_ROW, APOTHECARY_COLUMN))
                .setTreasury(getIntValueAtCoordinates(sheet, TREASURY_ROW, TREASURY_COLUMN))
                .setTeamValue(getIntValueAtCoordinates(sheet, TEAM_VALUE_ROW, TEAM_VALUE_COLUMN));
    }

    private RosterPlayer readPlayerData(final Row row) {
        final String name = row.getCell(PLAYER_NAME_COLUMN).getStringCellValue();
        final String position = row.getCell(PLAYER_POSITION_COLUMN).getStringCellValue();
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(position)) {
            return null;
        }
        return new RosterPlayer()
                .setNumber(getCellIntValue(row.getCell(PLAYER_NUMBER_COLUMN)))
                .setName(name)
                .setPosition(position)
                .setMovementAllowance(getCellIntValue(row.getCell(PLAYER_MA_COLUMN)))
                .setStrength(getCellIntValue(row.getCell(PLAYER_ST_COLUMN)))
                .setAgility(getCellIntValue(row.getCell(PLAYER_AG_COLUMN)))
                .setArmorValue(getCellIntValue(row.getCell(PLAYER_AV_COLUMN)))
                .setSkillsAndInjuries(row.getCell(PLAYER_SKILLS_AND_INJURIES_COLUMN).getStringCellValue())
                .setStatus(parseStatus(row.getCell(PLAYER_STATUS_COLUMN).getStringCellValue()))
                .setCompletions(getCellIntValue(row.getCell(PLAYER_CP_COLUMN)))
                .setTouchdowns(getCellIntValue(row.getCell(PLAYER_TD_COLUMN)))
                .setInterceptions(getCellIntValue(row.getCell(PLAYER_IN_COLUMN)))
                .setCasualties(getCellIntValue(row.getCell(PLAYER_CS_COLUMN)))
                .setMvps(getCellIntValue(row.getCell(PLAYER_MVP_COLUMN)))
                .setTotalSpps(getCellIntValue(row.getCell(PLAYER_SPP_COLUMN)))
                .setValue(getCellIntValue(row.getCell(PLAYER_VALUE_COLUMN)));
    }

    private String getStringAtCoordinates(final Sheet s, final int row, final int column) {
        return s.getRow(row).getCell(column).getStringCellValue();
    }

    private int getIntValueAtCoordinates(final Sheet s, final int row, final int column) {
        return getCellIntValue(s.getRow(row).getCell(column));
    }

    private int getCellIntValue(final Cell c) {
        try {
            return ((Double) c.getNumericCellValue()).intValue();
        } catch (final Exception e) {
            logger.warn("Error reading expected integer cell: ({}, {})", c.getRowIndex(), c.getColumnIndex());
            return 0;
        }
    }

    private PlayerState.PlayerStatus parseStatus(final String status) {
        if (StringUtils.isEmpty(status)) {
            return PlayerState.PlayerStatus.HEALTHY;
        } else if (MISS_NEXT_GAME.equals(status)) {
            return PlayerState.PlayerStatus.MISS_NEXT_GAME;
        } else if (JOURNEYMAN.equals(status)) {
            return PlayerState.PlayerStatus.JOURNEYMAN;
        } else {
            return PlayerState.PlayerStatus.UNKNOWN;
        }
    }
}
