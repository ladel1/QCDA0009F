package fr.eni.caveavin.dal;


import fr.eni.caveavin.bo.vin.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository  extends JpaRepository<Region,Integer> {
}
