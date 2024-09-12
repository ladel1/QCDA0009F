package fr.eni.demoheritage.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder // @Builder

@Entity
@DiscriminatorValue("medecin")
public class Medecin extends Personne{
    private String specialite;
    private String numMedecin;
    private float tarif;
}
