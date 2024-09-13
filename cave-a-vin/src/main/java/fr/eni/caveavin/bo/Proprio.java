package fr.eni.caveavin.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// Spring Data JPA
@Entity
@Table(name="CAV_OWNER")
public class Proprio extends Utilisateur{
    @Column(name="CLIENT_NUMBER",length = 14)
    private String siret;
}
