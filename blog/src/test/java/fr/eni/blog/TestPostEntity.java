package fr.eni.blog;

import fr.eni.blog.bo.Post;
import fr.eni.blog.dal.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TestPostEntity {

//    @Autowired
//    private PostRepository postRepository;
//
//    @Autowired
//    private TestEntityManager em;
//
//    @Test
//    @Commit
//    public void testSavePost(){
//
//        Post post = Post.builder()
//                .title("Formation Symfony")
//                .content("lbalbalablaba")
//                .author("Adel")
//                .createdAt(LocalDateTime.now())
//                .build();
//
//        Post postDb =  postRepository.save(post);
//        Assertions.assertThat(postDb).isNotNull();
//        Assertions.assertThat(postDb.getTitle()).isEqualTo("Formation Symfony");
//        System.out.println(postDb);
//    }
//
//    @Test
//    public void testPersistWithEm(){
//        Post post = Post.builder()
//                .title("Formation Spring")
//                .content("lbalbalablaba")
//                .author("Adel")
//                .createdAt(LocalDateTime.now())
//                .build();
//
//        em.persist(post);
//        em.flush();
//        Assertions.assertThat(post.getId()).isNotNull();
//        Assertions.assertThat(post.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testFindOne(){
//        final Integer id = 1;
//        Post post = Post.builder()
//                .title("Formation Symfony")
//                .content("lbalbalablaba")
//                .author("Adel")
//                .createdAt(LocalDateTime.now())
//                .build();
//        Optional<Post> postOpt = postRepository.findById(id);
//
//        postOpt.ifPresent((p)->{
//            postRepository.delete(p);
//        });
//
//        Assertions.assertThat(postOpt.isPresent()).isTrue();
//
//        postOpt.ifPresent( p->{ // p le post qu'on a recupéré depuis sqlserver
//            Assertions.assertThat(p.equals(post)).isTrue();
//        });
//    }
//
//
//    @Test
//    public void testFindAll(){
//        List<Post> posts = postRepository.findAll();
//        Assertions.assertThat(posts).isNotNull();
//        Assertions.assertThat(posts.size()).isGreaterThan(0);
//        posts.forEach(System.out::println);
//    }
//
//    @Test
//    public void testFindByTitle(){
//        final String title = "%symfony%";
//        List<Post> posts = postRepository.findByTitleLike(title);
//        Assertions.assertThat(posts).isNotNull();
//        Assertions.assertThat(posts.size()).isGreaterThan(0);
//        posts.forEach(System.out::println);
//    }

}
