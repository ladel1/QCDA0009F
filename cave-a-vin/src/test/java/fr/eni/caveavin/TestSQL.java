package fr.eni.caveavin;

import fr.eni.caveavin.bo.vin.Bouteille;
import fr.eni.caveavin.dal.BouteilleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestSQL {

    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    public void testSearchByRegion(){
        //Arrange
        String region = "Bordeaux";
        //ACt
        List<Bouteille> bouteilleList = bouteilleRepository.searchByRegion(region);
        // ASSERT
        Assertions.assertThat(bouteilleList).isNotNull();
        Assertions.assertThat(bouteilleList).hasSize(1);
        System.out.println(bouteilleList);
    }

    @Test
    public void testSearchByColor(){
        //Arrange
        String couleur = "Rouge";
        //ACt
        List<Bouteille> bouteilleList = bouteilleRepository.searchByColor(couleur);
        // ASSERT
        Assertions.assertThat(bouteilleList).isNotNull();
        Assertions.assertThat(bouteilleList).hasSize(1);
        System.out.println(bouteilleList);
    }

}
