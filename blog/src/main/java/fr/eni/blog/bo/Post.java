package fr.eni.blog.bo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="posts")
public class Post {

    @EmbeddedId
    private PostPk id;

    @Column(length = 500)
    private String content;

    @ToString.Exclude
    private LocalDateTime createdAt;

}
