package fr.eni.blog.bo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of={"title"})
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 500)
    private String content;

    @NonNull
    @Column(length = 500,nullable = false)
    private String author;

    @ToString.Exclude
    private LocalDateTime createdAt;

}
