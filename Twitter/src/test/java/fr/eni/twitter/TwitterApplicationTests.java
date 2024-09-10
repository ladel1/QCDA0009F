package fr.eni.twitter;

import fr.eni.twitter.bo.Profile;
import fr.eni.twitter.bo.User;
import fr.eni.twitter.dal.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class TwitterApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
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
        System.out.println(userBdd.getProfile());
    }

}
