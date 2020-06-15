package babble.rest.controllers;

import babble.rest.input.UserPayload;
import babble.services.UserService;
import babble.services.output.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto create(@RequestBody final UserPayload payload) {
        return userService.create(payload.getUsername(), payload.getPassword(), payload.getFirstName(), payload.getLastName());
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    public UserDto findById(@PathVariable final long id) {
        return userService.findById(id);
    }
}
