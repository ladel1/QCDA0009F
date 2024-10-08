package fr.eni.comptebancaire.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "comptes")
@IdClass(ComptePK.class)
public class Compte {
    @Id
    @Column(unique = true, nullable = false)
    private String numCompte;
    @Id
    @Column(unique = true, nullable = false)
    private String pseudo;

    private double solde;

}
