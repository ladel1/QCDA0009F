package fr.eni.comptebancaire;

import fr.eni.comptebancaire.bll.CompteService;
import fr.eni.comptebancaire.bo.Compte;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestCompteService {

    @Autowired
    private CompteService compteService;

    @Test
    public void testSaveCompte() {

        Compte compteLucas = Compte.builder()
                .numCompte("FR00000001")
                .solde(0)
                .pseudo("Lucas")
                .build();
        Compte compteGaelle = Compte.builder()
                .numCompte("FR00000002")
                .solde(0)
                .pseudo("Gaelle")
                .build();

        compteService.ajouterCompte(compteLucas);
        compteService.ajouterCompte(compteGaelle);

        Assertions.assertThat(compteLucas).isNotNull();
        Assertions.assertThat(compteLucas).isNotNull();

    }

    @Test
    public void testCrediter(){
        Optional<Compte> lucasCompteOpt = compteService.recuperCompteParNum("FR00000001");

        double oldSolde =0;
        if(lucasCompteOpt.isPresent()){
            oldSolde = lucasCompteOpt.get().getSolde();
        }
        Assertions.assertThat(lucasCompteOpt).isPresent();
        Compte lucasCompte = lucasCompteOpt.get();
        compteService.crediter(lucasCompte,2000);
        Assertions.assertThat(lucasCompte.getSolde()).isEqualTo(oldSolde+2000);
    }

    @Test
    public void testDebiter(){
        Optional<Compte> lucasCompteOpt = compteService.recuperCompteParNum("FR00000001");

        double oldSolde =0;
        if(lucasCompteOpt.isPresent()){
            oldSolde = lucasCompteOpt.get().getSolde();
        }
        Assertions.assertThat(lucasCompteOpt).isPresent();
        Compte lucasCompte = lucasCompteOpt.get();
        try {
            compteService.debiter(lucasCompte,500);
            Assertions.assertThat(lucasCompte.getSolde()).isEqualTo(oldSolde-500);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void testVirement(){
        Optional<Compte> lucasCompteOpt = compteService.recuperCompteParNum("FR00000001");
        Optional<Compte> gaelleCompteOpt = compteService.recuperCompteParNum("FR00000002");

        Assertions.assertThat(lucasCompteOpt).isPresent();
        Assertions.assertThat(gaelleCompteOpt).isPresent();

        try {
            compteService.virement(lucasCompteOpt.get(),gaelleCompteOpt.get(),1000);
            Assertions.assertThat(lucasCompteOpt.get().getSolde()).isEqualTo(2500);
            Assertions.assertThat(gaelleCompteOpt.get().getSolde()).isEqualTo(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
