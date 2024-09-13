package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.vin.Bouteille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BouteilleRepository extends JpaRepository<Bouteille,Integer> {

    @Query(value="SELECT b.* FROM CAV_BOTTLE b INNER JOIN CAV_REGION r ON b.REGION_ID = r.REGION_ID WHERE r.NAME = :name",nativeQuery = true)
   List<Bouteille> searchByRegion(@Param("name") String name);

    @Query(value="SELECT b.* FROM CAV_BOTTLE b INNER JOIN CAV_COLOR c ON b.COLOR_ID = c.COLOR_ID WHERE c.NAME = :name",nativeQuery = true)
   List<Bouteille> searchByColor(@Param("name") String name);

}
