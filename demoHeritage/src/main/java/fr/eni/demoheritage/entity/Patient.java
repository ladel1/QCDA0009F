package fr.eni.demoheritage.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder // @Builder

@Entity
//@DiscriminatorValue("patient")
@Table(name="patients")
public class Patient extends Personne{
    private String nss;
}
