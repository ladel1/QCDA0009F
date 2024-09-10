package fr.eni.blog.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Data
//@EqualsAndHashCode(of={"title","author"})
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class PostPk  implements Serializable {

    @Column(length = 200, nullable = false, unique = true)
    private String title;


    @Column(length = 500,nullable = false, unique = true)
    private String author;
}
