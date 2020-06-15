package babble.rest.controllers;

import babble.rest.input.LeaguePayload;
import babble.services.LeagueService;
import babble.services.output.LeagueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "league", produces = "application/json")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @PostMapping
    public LeagueDto create(@RequestBody final LeaguePayload payload) {
//        if (StringUtils.isBlank(name)) {
//        }
        return leagueService.create(payload.getName());
    }

    @GetMapping
    public List<LeagueDto> getAll() {
        return leagueService.list();
    }

    @GetMapping(value = "/{id}")
    public LeagueDto findById(@PathVariable final long id) {
        return leagueService.findById(id);
    }

    @PostMapping("/{id}/coach/{coachId}")
    public LeagueDto subscribeCoach(@PathVariable final long id, @PathVariable final long coachId) {
        leagueService.subscribeCoach(id, coachId);
        return leagueService.findById(id);
    }
}
