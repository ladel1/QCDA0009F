package fr.eni.demoheritage;

import fr.eni.demoheritage.entity.Medecin;
import fr.eni.demoheritage.entity.Patient;
import fr.eni.demoheritage.repository.MedecinRepository;
import fr.eni.demoheritage.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestHeritage {

    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void saveMedecin(){
        System.out.println("*********************  Save medecin   ***************************");
        // Arrange
        Medecin medecin = Medecin.builder()
                .nom("Maisel")
                .prenom("Steve")
                .email("s.maisel@gmail.com")
                .tel("0215487986")
                .adresse("Quimper")
                .dateDeNaissance(LocalDate.now())
                .specialite("Cardiologue")
                .numMedecin("FR00001")
                .tarif(26f)
                .build();
        // ACT
        Medecin savedMedecin = medecinRepository.save(medecin);
        // Assert
        Assertions.assertThat(savedMedecin.getId()).isGreaterThan(0);
        System.out.println(savedMedecin);
    }

    public void savePatient(){
        System.out.println("*********************  Save Patient   ***************************");
        // Arrange
        Patient patient = Patient.builder()
                .nom("De lor")
                .prenom("Sarah")
                .email("dl.sarah@gmail.com")
                .tel("0215487986")
                .adresse("Paris")
                .nss("321654987321")
                .dateDeNaissance(LocalDate.now())
                .build();
        // ACT
        Patient savedPatient = patientRepository.save(patient);
        // Assert
        Assertions.assertThat(savedPatient.getId()).isGreaterThan(0);
        System.out.println(savedPatient);
    }


}
