package babble.services.roster.reader;

import babble.services.roster.data.Roster;
import org.apache.poi.ss.usermodel.Workbook;

public interface RosterReader {

    Roster readRoster(Workbook rosterFile);
}
