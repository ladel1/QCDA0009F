package fr.eni.blog;

import fr.eni.blog.bo.Post;
import fr.eni.blog.bo.PostPk;
import fr.eni.blog.dal.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class TestEmbeddedId {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testGetById(){
        // construire id
        PostPk pk = PostPk.builder()
                .title("Formation NextJs et NestJs")
                .author("Pierre")
                .build();
        // construire l'instance post
        Post post = Post.builder()
                .id(pk)
                .content("balbalbalabal")
                .createdAt(LocalDateTime.now())
                .build();
        // on sauvgrade dans la bdd
        Post savedPost = postRepository.save(post);
        // un assert pour tester
        Assertions.assertThat(savedPost).isNotNull();
        // on récupere le post qu'on vien de sauvgarder
        Optional<Post> postOpt = postRepository.findById(savedPost.getId());
        Assertions.assertThat(postOpt).isPresent();
        System.out.println(postOpt.get());
    }

}
