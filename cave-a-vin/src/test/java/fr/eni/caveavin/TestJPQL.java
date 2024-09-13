package fr.eni.caveavin;

import fr.eni.caveavin.bo.Utilisateur;
import fr.eni.caveavin.dal.UtilisateurRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestJPQL {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void testSearchByPseudo(){
        // Arrange
        String pseudo = "msarah";
        // act
        Utilisateur user = utilisateurRepository.SearchByPseudo(pseudo);
        // Assert
        Assertions.assertThat(user).isNotNull();
        System.out.println(user);
    }

    @Test
    public void testSearchByPseudoAndPassword(){
        // Arrange
        String pseudo = "msarah";
        String password = "123456";
        // act
        Utilisateur user = utilisateurRepository.SearchByPseudoAndPassword(pseudo,password);
        // Assert
        Assertions.assertThat(user).isNotNull();
        System.out.println(user);
    }

}
