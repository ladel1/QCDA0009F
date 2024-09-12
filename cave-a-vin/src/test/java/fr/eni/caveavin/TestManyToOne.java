package fr.eni.caveavin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.eni.caveavin.bo.vin.Bouteille;
import fr.eni.caveavin.bo.vin.Couleur;
import fr.eni.caveavin.bo.vin.Region;
import fr.eni.caveavin.dal.BouteilleRepository;
import fr.eni.caveavin.dal.CouleurRepository;
import fr.eni.caveavin.dal.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
public class TestManyToOne {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	BouteilleRepository bouteilleRepository;

	@Autowired
	CouleurRepository couleurRepository;
	
	@Autowired
	RegionRepository regionRepository;
	
	Couleur rouge;
	Couleur blanc;
	Couleur rose;
	
	Region grandEst;
	Region paysDeLaLoire;
	Region nouvelleAquitaine;

	@BeforeEach
	public void initDB() {
		System.out.println("******* initDB ********");
		rouge = Couleur
				.builder()
				.nom("Rouge")
				.build();
		
		blanc = Couleur
				.builder()
				.nom("Blanc")
				.build();
				
		rose = Couleur
				.builder()
				.nom("Rosé")
				.build();
				
		couleurRepository.save(rouge);
		couleurRepository.save(blanc);
		couleurRepository.save(rose);
				
		grandEst = 
				Region
				.builder()
				.nom("Grand Est")
				.build();
		
		paysDeLaLoire = 
				Region
				.builder()
				.nom("Pays de la Loire")
				.build();
		
		nouvelleAquitaine = 
				Region
				.builder()
				.nom("Nouvelle Aquitaine")
				.build();
		
		regionRepository.save(grandEst);
		regionRepository.save(paysDeLaLoire);
		regionRepository.save(nouvelleAquitaine);
	}

	//TODO

	private List<Bouteille> jeuDeDonnees() {
		System.out.println("******* jeuDeDonnees ********");
		List<Bouteille> bouteilles = new ArrayList<>();
		bouteilles.add(Bouteille
				.builder()
				.nom("Blanc du DOMAINE ENI Ecole")
				.millesime("2022")
				.prix(23.95f)
				.quantite(1298)
				.region(paysDeLaLoire)
				.couleur(blanc)
				.build());
		bouteilles.add(Bouteille
				.builder()
				.nom("Rouge du DOMAINE ENI Ecole")
				.millesime("2018")
				.prix(11.45f)
				.quantite(987)
				.region(paysDeLaLoire)
				.couleur(rouge)
				.build());
		bouteilles.add(Bouteille
				.builder()
				.nom("Blanc du DOMAINE ENI Service")
				.millesime("2022")
				.prix(34)
				.petillant(true)
				.quantite(111)
				.region(grandEst)
				.couleur(blanc)
				.build());
		bouteilles.add(Bouteille
				.builder()
				.nom("Rouge du DOMAINE ENI Service")
				.millesime("2012")
				.prix(8.15f)
				.quantite(344)
				.region(paysDeLaLoire)
				.couleur(rouge)
				.build());
		bouteilles.add(Bouteille
				.builder()
				.nom("Rosé du DOMAINE ENI")
				.millesime("2020")
				.prix(33)
				.quantite(1987)
				.region(nouvelleAquitaine)
				.couleur(rose)
				.build());
		return bouteilles;
	}

	@Test
	public void testSave(){
		System.out.println("******* testSave ********");
		Bouteille bouteille = Bouteille
				.builder()
				.nom("Blanc du DOMAINE ENI Ecole")
				.millesime("2022")
				.prix(23.95f)
				.quantite(1298)
				.region(paysDeLaLoire)
				.couleur(blanc)
				.build();

		Bouteille savedBouteille = bouteilleRepository.save(bouteille);

		assertThat(savedBouteille.getId()).isGreaterThan(0);
		assertThat(savedBouteille.getCouleur()).isNotNull();
		assertThat(savedBouteille.getRegion()).isNotNull();
		System.out.println(savedBouteille);

	}



	@Test
	public void testSaveBouteillesRegsionCouleurs(){

		List<Bouteille> bouteilles = jeuDeDonnees();
		List<Bouteille> savedBouteilles = bouteilleRepository.saveAll(bouteilles);
		System.out.println("******* testSaveBouteillesRegsionCouleurs ********");
		savedBouteilles.forEach(bouteille -> {
			assertThat(bouteille.getId()).isGreaterThan(0);
			assertThat(bouteille.getCouleur()).isNotNull();
			assertThat(bouteille.getRegion()).isNotNull();
			System.out.println(bouteille);
		});
	}
	@Test
	public void testDelete(){
		// Arrange
		Bouteille bouteille = Bouteille
				.builder()
				.nom("Blanc du DOMAINE ENI Ecole")
				.millesime("2022")
				.prix(23.95f)
				.quantite(1298)
				.region(paysDeLaLoire)
				.couleur(blanc)
				.build();
		// ACT
		Bouteille savedBouteille = bouteilleRepository.saveAndFlush(bouteille);
		// ASSERT
		assertThat(savedBouteille.getId()).isGreaterThan(0);
		bouteilleRepository.delete(savedBouteille);

		Optional<Couleur> couleurOpt =  couleurRepository.findById(savedBouteille.getCouleur().getId());
		assertThat(couleurOpt).isPresent();
		System.out.println(couleurOpt.get());
		Optional<Region> regionOpt = regionRepository.findById(savedBouteille.getRegion().getId());
		assertThat(regionOpt).isPresent();
		System.out.println(regionOpt.get());


	}

}
