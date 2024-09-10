package fr.eni.caveavin.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

// LOmbok
@Data
@ToString(of={"pseudo","nom","prenom"})
@EqualsAndHashCode(of={"pseudo"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Spring Data JPA
@Entity
@Table(name="CAV_CLIENT")
public class Client {
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
