package fr.eni.twitter;

import fr.eni.twitter.bo.Profile;
import fr.eni.twitter.bo.User;
import fr.eni.twitter.dal.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
    }
    // JPQL
    @Test
    public void testSearchByUsername(){
        // Arrange
        String motCle = "erre";
        // Act
        List<User> users = userRepository.searchUserByUsername(motCle);
        // Assert
        Assertions.assertThat(users).hasSize(1);
        System.out.println(users);
    }
    /// SQL
    @Test
    public void testSearchByEmail(){
        // Arrange
        String motCle = "pierre@gmail.com";
        // Act
        Optional<User> userOpt = userRepository.searchByemail(motCle);
        // Assert
        Assertions.assertThat(userOpt).isPresent();
        System.out.println(userOpt.get());
    }

}
