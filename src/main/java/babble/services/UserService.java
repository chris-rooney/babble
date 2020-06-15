package babble.services;

import babble.data.access.UserRepository;
import babble.data.models.User;
import babble.services.output.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(UserService::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public UserDto findById(final long id) {
        return toDto(userRepository.findById(id).orElse(null));
    }

    public UserDto create(final String username, final String password, final String firstName, final String lastName) {
        // TODO Look up spring boot password hashing
        final User user = new User(username, password, firstName, lastName);
        return toDto(userRepository.save(user));
    }

    static UserDto toDto(final User user) {
        if (user == null) {
            return null;
        }
        return UserDto.newBuilder()
                .setId(user.getUserId())
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .build();
    }
}
