package fr.eni.caveavin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import fr.eni.caveavin.bo.client.LignePanier;
import fr.eni.caveavin.bo.client.Panier;
import fr.eni.caveavin.dal.LignePanierRepository;
import fr.eni.caveavin.dal.PanierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;


@DataJpaTest
public class TestOneToManyUni {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	PanierRepository repository;
	@Autowired
	LignePanierRepository lignePanierRepository;

	@Test
	public void testSaveNewLineNewShoppingCart(){
		Panier panier = panierEnDB();
		System.out.println(panier);
	}

	@Test
	public void testSaveNewLine(){
		Panier panierDb = panierEnDB();
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
		Panier panierDb =  panierEnDB();
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
		Panier panierDb =  panierEnDB();
		panierDb.getLignesPanier().clear();
		repository.saveAndFlush(panierDb);
		Optional<LignePanier> lignePanierOpt = lignePanierRepository.findById(1);
		assertThat(lignePanierOpt).isNotPresent();
	}

	private Panier panierEnDB() {
		final Panier panier = new Panier();
		final LignePanier lp = LignePanier
				.builder()
				.quantite(3)
				.prix(3 * 11.45f)
				.build();
		panier.getLignesPanier().add(lp);
		panier.setPrixTotal(lp.getPrix());

		entityManager.persist(panier);
		entityManager.flush();

		assertThat(panier.getId()).isGreaterThan(0);
		assertThat(panier.getId()).isGreaterThan(0);

		return panier;
	}
}
