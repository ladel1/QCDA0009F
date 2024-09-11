package fr.eni.caveavin;

import fr.eni.caveavin.bo.client.Client;
import fr.eni.caveavin.dal.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class TestClientJpa {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveClient() {
        Client client = Client.builder()
                .pseudo("ladel")
                .prenom("Adel")
                .nom("Latibi")
                .password("azerty")
                .build();
        // appel de comportement
        Client clientDb = clientRepository.save(client);
        // verif
        Assertions.assertThat(clientDb).isNotNull();
        Assertions.assertThat(clientDb).isEqualTo(client);

        Assertions.assertThat(clientDb.toString().contains("password")).isFalse();


    }

    @Test
    public void testDeleteClient() {
        Client client = Client.builder()
                .pseudo("ladel")
                .prenom("Adel")
                .nom("Latibi")
                .password("azerty")
                .build();
        // appel de comportement
        Client clientDb = clientRepository.save(client);
        System.out.println(clientDb);
        clientRepository.delete(clientDb);

        //
        Optional<Client> clientOpt = clientRepository.findById("ladel");
        Assertions.assertThat(clientOpt.isEmpty()).isTrue();


    }


}
