package fr.eni.caveavin.bo.vin;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="CAV_BOTTLE")
public class Bouteille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOTTLE_ID")
    private Integer id;
    @Column(name = "NAME")
    private String nom;
    @Column(name = "SPARKLING")
    private boolean petillant;
    @Column(name = "VINTAGE")
    private String millesime;
    @Column(name = "QUANTITY")
    private int quantite;
    @Column(name = "PRICE")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "COLOR_ID")
    @EqualsAndHashCode.Exclude
    private Couleur couleur;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    @EqualsAndHashCode.Exclude
    private Region region;

}
