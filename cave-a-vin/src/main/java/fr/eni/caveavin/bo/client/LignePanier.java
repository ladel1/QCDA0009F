package fr.eni.caveavin.bo.client;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of={"id"})

@Entity
@Table(name="CAV_LINE")
public class LignePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINE_ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private int quantite;
    @Column(name = "PRICE", precision = 2)
    private float prix;
}
