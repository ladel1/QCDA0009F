package fr.eni.caveavin;
import fr.eni.caveavin.bo.Adresse;
import fr.eni.caveavin.bo.Client;
import fr.eni.caveavin.dal.AdresseRepository;
import fr.eni.caveavin.dal.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class TestAssociationClientAdresse {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdresseRepository adresseRepository;

    @BeforeEach
    public void init(){
        System.out.println("Début d'un test....");
        Adresse adresse = Adresse.builder()
                .rue("15 Rue machin")
                .codePostal("29000")
                .ville("Quimper")
                .build();

        Client client = Client.builder()
                .pseudo("d_pierre")
                .prenom("Pierre")
                .nom("Duval")
                .password("4654987")
                .adresse(adresse)
                .build();
        clientRepository.save(client);
    }

    @Test
    public void testSavedClientAddress(){

        final String clientLogin = "d_pierre";
        Optional<Client> clientOpt = clientRepository.findById(clientLogin);

        Assertions.assertThat(clientOpt).isPresent();
        Assertions.assertThat(clientOpt.get().getAdresse()).isNotNull();

        System.out.println(clientOpt.get());
        System.out.println(clientOpt.get().getAdresse());


    }

    @Test
    public void testDeleteClient(){
        final String clientLogin = "d_pierre";
        Optional<Client> clientOpt = clientRepository.findById(clientLogin);
        Assertions.assertThat(clientOpt).isPresent();
        clientRepository.delete(clientOpt.get());
        Optional<Client> client2Opt = clientRepository.findById(clientLogin);
        Assertions.assertThat(client2Opt).isEmpty();
        Optional<Adresse> adresseOpt = adresseRepository.findById(1);
        Assertions.assertThat(adresseOpt).isNotPresent();
    }

}
