package fr.eni.twitter.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id","name"})
@EqualsAndHashCode(of={"id","name"})
@Builder
@Entity
@Table(name = "hashtags")
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    // Many to Many association
    @Builder.Default
    @ManyToMany(mappedBy = "hashTags")
    private List<Tweet> tweets = new ArrayList<>();
}
