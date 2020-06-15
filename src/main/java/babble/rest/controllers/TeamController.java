package babble.rest.controllers;

import babble.rest.input.TeamPayload;
import babble.services.TeamService;
import babble.services.output.TeamDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "team", produces = "application/json")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public TeamDto create(@RequestBody final TeamPayload payload) {
        final TeamDto team = teamService.createTeam(payload.getCoachUserId(), payload.getLeagueId(), payload.getRaceId(), payload.getTeamName());
        // Reload links TODO There has to be a better way
        return teamService.findById(team.getId());
    }

    @GetMapping
    public List<TeamDto> getAll() {
        return teamService.getAllTeams();
    }

    @GetMapping(value = "/{id}")
    public TeamDto findById(@PathVariable final long id) {
        return teamService.findById(id);
    }

    @PostMapping(value = "/{id}/roster")
    public TeamDto upload(@PathVariable final long id, @RequestParam("file") final MultipartFile file) {
        final TeamDto team = teamService.findById(id);
        if (team == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (!file.getOriginalFilename().endsWith("xlsx") && !file.getOriginalFilename().endsWith(".xls")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Roster file must be an Excel spreadsheet (xls, xlsx)");
        }
        final Workbook uploadedRoster;
        try {
            uploadedRoster = WorkbookFactory.create(file.getInputStream());
        } catch (final IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error reading roster file", e);
        }

        teamService.processUpload(id, uploadedRoster);
        // Reload links TODO There has to be a better way
        return teamService.findById(id);
    }
}
