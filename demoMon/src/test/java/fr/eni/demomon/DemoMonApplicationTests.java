package fr.eni.demomon;

import fr.eni.demomon.entity.Avis;
import fr.eni.demomon.entity.Utilisateur;
import fr.eni.demomon.repository.AvisRepository;
import fr.eni.demomon.repository.UtilisateurRepository;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoMonApplicationTests {

    @Autowired
    private AvisRepository avisRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Test
    void contextLoads() {
        Optional<Utilisateur> savedUser = utilisateurRepository.findById("66e40df642172418357f5cad") ;
        Assertions.assertThat(savedUser).isPresent();
        Avis avis = Avis.builder()
                .commentaireCours("ooollaa")
                .author(savedUser.get())
                .build();
        Avis savedAvis = avisRepository.save(avis);
        Assertions.assertThat(savedAvis.getId()).isNotNull();
        System.out.println(savedAvis);
    }
    @Test
    public void saveUser(){
        Utilisateur user= Utilisateur.builder()
                .pseudo("LaFleur")
                .build();
        utilisateurRepository.save(user);
    }


    @Test
    void  testFindAll(){

        List<Avis> avis = avisRepository.findAll();

        Assertions.assertThat(avis).hasSize(1);
        avis.forEach(avis1 -> {
            System.out.println(avis1);
        });
    }

}
