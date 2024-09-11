package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.client.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse,Integer> {
}
