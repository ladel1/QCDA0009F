package fr.eni.caveavin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import fr.eni.caveavin.bo.Proprio;
import fr.eni.caveavin.bo.Utilisateur;
import fr.eni.caveavin.bo.client.Client;
import fr.eni.caveavin.dal.ClientRepository;
import fr.eni.caveavin.dal.ProprioRepository;
import fr.eni.caveavin.dal.UtilisateurRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TestHeritage {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	ProprioRepository proprioRepository;

	@Autowired
	ClientRepository clientRepository;

	@BeforeEach
	public void initDB() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurs.add(Utilisateur
				.builder()
				.pseudo("harrisonford@email.fr")
				.password("IndianaJones3")
				.nom("Ford")
				.prenom("Harrison")
				.build());

		utilisateurs.add(Proprio
				.builder()
				.pseudo("georgelucas@email.fr")
				.password("Réalisateur&Producteur")
				.nom("Lucas")
				.prenom("George")
				.siret("12345678901234")
				.build());

		utilisateurs.add(Client
				.builder()
				.pseudo("natalieportman@email.fr")
				.password("MarsAttacks!")
				.nom("Portman")
				.prenom("Natalie")
				.build());

		// Contexte de la DB
		utilisateurs.forEach(e -> {
			entityManager.persist(e);
		});
	}
	@Test
	public void testFindAllUsers(){
		List<Utilisateur> users = utilisateurRepository.findAll();
		assertThat(users).isNotEmpty();
		assertThat(users).hasSize(3);
		System.out.println(users);
	}
	@Test
	public void testFindAllClients(){
		List<Client> clients = clientRepository.findAll();
		assertThat(clients).isNotEmpty();
		assertThat(clients).hasSize(1);
		System.out.println(clients);
	}
	@Test
	public void testFindAllProprios(){
		List<Proprio> proprios = proprioRepository.findAll();
		assertThat(proprios).isNotEmpty();
		assertThat(proprios).hasSize(1);
		System.out.println(proprios);
	}
}
