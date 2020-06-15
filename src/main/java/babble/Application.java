package babble;

import babble.data.access.RefreshableRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = RefreshableRepositoryImpl.class)
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}