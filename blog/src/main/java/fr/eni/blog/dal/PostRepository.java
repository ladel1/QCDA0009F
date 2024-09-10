package fr.eni.blog.dal;

import fr.eni.blog.bo.Post;
import fr.eni.blog.bo.PostPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository  extends JpaRepository<Post, PostPk> {
    //List<Post> findByTitleLike(String title);
}
