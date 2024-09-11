package fr.eni.caveavin.bo.client;

import jakarta.persistence.*;
import lombok.*;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
// Spring Data JPA
@Entity
@Table(name="CAV_ADDRESS")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Integer id;
    @Column(name = "Street")
    private String rue;
    @Column(name = "POSTAL_CODE")
    private String codePostal;
    @Column(name = "CITY")
    private String ville;

}
