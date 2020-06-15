package babble.rest.controllers;

import babble.rest.input.SeasonPayload;
import babble.services.SeasonService;
import babble.services.output.SeasonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "season", produces = "application/json")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @PostMapping
    public SeasonDto create(@RequestBody final SeasonPayload payload) {
        return seasonService.create(payload.getLeagueId(), payload.getName());
    }

    @GetMapping
    public List<SeasonDto> getAllForLeague(@RequestParam(value = "leagueId") final long leagueId) {
        return seasonService.getAllForLeague(leagueId);
    }

    @GetMapping(value = "/{id}")
    public SeasonDto findById(@PathVariable final long id) {
        return seasonService.findById(id);
    }

    @PostMapping("/{id}/team/{teamId}")
    public SeasonDto subscribeTeam(@PathVariable final long id, @PathVariable final long teamId) {
        seasonService.subscribeTeam(id, teamId);
        return seasonService.findById(id);
    }
}
