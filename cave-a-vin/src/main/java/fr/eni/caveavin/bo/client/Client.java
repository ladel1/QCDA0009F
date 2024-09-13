package fr.eni.caveavin.bo.client;

import fr.eni.caveavin.bo.Utilisateur;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

// LOmbok
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// Spring Data JPA
@Entity
@Table(name="CAV_CLIENT")
public class Client extends Utilisateur {


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_ID")
    private Adresse adresse;

}
