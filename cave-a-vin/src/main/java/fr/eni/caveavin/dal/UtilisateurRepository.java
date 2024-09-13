package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {

    @Query("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo")
    Utilisateur SearchByPseudo(@Param("pseudo") String pseudo);

    @Query("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo AND u.password = :password")
    Utilisateur SearchByPseudoAndPassword(@Param("pseudo") String pseudo,@Param("password") String password);

}
