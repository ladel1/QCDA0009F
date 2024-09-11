package fr.eni.twitter;

import fr.eni.twitter.bo.Profile;
import fr.eni.twitter.bo.User;
import fr.eni.twitter.dal.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class TwitterApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Commit
    void contextLoads() {
        Profile profile = Profile.builder()
                .firstname("Pierre")
                .lastname("Maisel")
                .build();
        User user = User.builder()
                .username("MPierre")
                .password("12345687")
                .profile(profile)
                .dateCreated(LocalDate.now())
                .build();

        User userBdd = userRepository.save(user);
        Assertions.assertThat(userBdd).isNotNull();

        Long userId = 1L;
        Optional<User> userOpt = userRepository.findById(userId);

        userOpt.ifPresent(System.out::println);

    }

}
