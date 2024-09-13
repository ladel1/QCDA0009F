package fr.eni.caveavin.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString(of={"pseudo","nom","prenom"})
@EqualsAndHashCode(of={"pseudo"})
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// Spring Data JPA
@Entity
@Table(name="CAV_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @Column(name = "LOGIN",nullable = false,length = 50)
    private String pseudo;
    @Column(name = "PASSWORD",nullable = false,length = 255)
    private String password;
    @Column(name = "LAST_NAME",nullable = false,length = 50)
    private String nom;
    @Column(name = "FIRST_NAME",nullable = false,length = 50)
    private String prenom;
}
