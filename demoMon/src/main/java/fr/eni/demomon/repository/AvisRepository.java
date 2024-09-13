package fr.eni.demomon.repository;

import fr.eni.demomon.entity.Avis;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisRepository extends MongoRepository<Avis, String> {
}
