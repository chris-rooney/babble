package babble.rest.controllers;

import babble.services.RulesService;
import babble.services.output.rules.RaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RulesController {

    @Autowired
    private RulesService rulesService;

    @GetMapping(value = "/race")
    public List<RaceDto> getRaces() {
        return rulesService.getRaces();
    }

    @GetMapping(value = "/race/{id}")
    public RaceDto getRaces(@PathVariable final long id) {
        return rulesService.getRaceById(id);
    }
}
