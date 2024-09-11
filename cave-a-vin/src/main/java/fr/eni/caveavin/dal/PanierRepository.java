package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.client.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier,Integer> {
}
