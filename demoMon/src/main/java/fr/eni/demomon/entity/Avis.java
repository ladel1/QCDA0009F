package fr.eni.demomon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "REVIEWS")
public class Avis {
    @Id
    private String id;
    private int notePedagogie;
    private String commentairePedagogie;
    private int noteCours;
    private String commentaireCours;
    @DocumentReference(lazy = true)
    private Utilisateur author;
}
