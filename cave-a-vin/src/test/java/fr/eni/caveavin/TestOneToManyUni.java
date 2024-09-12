package fr.eni.caveavin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import fr.eni.caveavin.bo.client.LignePanier;
import fr.eni.caveavin.bo.client.Panier;
import fr.eni.caveavin.dal.LignePanierRepository;
import fr.eni.caveavin.dal.PanierRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestOneToManyUni {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	PanierRepository repository;
	@Autowired
	LignePanierRepository lignePanierRepository;

	@BeforeEach
	public void setUp(){
		System.out.println("***************    Set Up    *************************");
		final Panier panier = new Panier();
		final LignePanier lp = LignePanier
				.builder()
				.quantite(3)
				.prix(3 * 11.45f)
				.build();
		panier.getLignesPanier().add(lp);
		panier.setPrixTotal(lp.getPrix());

		repository.save(panier);
		System.out.println(repository.findAll());
	}

	@Test
	public void testSaveNewLineNewShoppingCart(){
		System.out.println("TestOneToManyUni.testSaveNewLineNewShoppingCart");
		Optional<Panier> panier = repository.findById(1);
		System.out.println(panier);
	}

	@Test
	public void testSaveNewLine(){
		System.out.println("TestOneToManyUni.testSaveNewLine");
		Optional<Panier>  panierDbOpt = repository.findById(1);
		assertThat(panierDbOpt).isPresent();
		Panier panierDb = panierDbOpt.get();
		LignePanier newLine = LignePanier.builder()
				.quantite(10)
				.prix(2.41f*10)
				.build();

		panierDb.getLignesPanier().add(newLine);
		panierDb.setPrixTotal( panierDb.getPrixTotal() + newLine.getPrix() );

		Panier savedPanier = repository.save(panierDb);

		assertThat(savedPanier).isNotNull();
		assertThat(savedPanier.getLignesPanier().size()).isEqualTo(2);
		System.out.println(savedPanier);

	}
	@Test
	public void testDelete(){
		System.out.println("TestOneToManyUni.testDelete");
		Optional<Panier>  panierDbOpt = repository.findById(1);
		assertThat(panierDbOpt).isPresent();
		Panier panierDb = panierDbOpt.get();
		repository.delete(panierDb);
		Optional<Panier> panierOpt = repository.findById(1);
		assertThat(panierOpt).isNotPresent();
		System.out.println(panierDb);
		panierDb.getLignesPanier().forEach( line->{
			Optional<LignePanier> lineOpt = lignePanierRepository.findById(line.getId());
			assertThat(lineOpt).isNotPresent();
		} );
	}
	@Test
	public void testOrphanRemoval(){
		System.out.println("TestOneToManyUni.testOrphanRemoval");
		Optional<Panier>  panierDbOpt = repository.findById(1);
		assertThat(panierDbOpt).isPresent();
		Panier panierDb = panierDbOpt.get();
		panierDb.getLignesPanier().clear();
		repository.saveAndFlush(panierDb);
		Optional<LignePanier> lignePanierOpt = lignePanierRepository.findById(1);
		assertThat(lignePanierOpt).isNotPresent();
	}

//	@AfterEach
//	@Transactional
//	public void resetAutoIncrement() {
//		entityManager.getEntityManager().createNativeQuery("ALTER TABLE CAV_SHOPPING_CART AUTO_INCREMENT = 1").executeUpdate();
//		entityManager.flush();
//	}

}
