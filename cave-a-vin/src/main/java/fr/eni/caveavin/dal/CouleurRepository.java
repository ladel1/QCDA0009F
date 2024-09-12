package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.vin.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository  extends JpaRepository<Couleur,Integer> {
}
