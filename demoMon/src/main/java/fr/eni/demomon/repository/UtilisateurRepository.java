package fr.eni.demomon.repository;

import fr.eni.demomon.entity.Utilisateur;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
}
