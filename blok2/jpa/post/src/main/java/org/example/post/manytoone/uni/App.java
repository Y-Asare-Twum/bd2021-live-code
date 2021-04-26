package org.example.post.manytoone.uni;

import org.example.AppInit;

import java.util.List;

import static org.example.Config.manyToOneUni;
import static org.example.Config.persist;

public class App extends AppInit {

    public void start() {
        Post post = Post.builder().title("first").build();

        PostComment my_first_review = PostComment.builder().title("My first review").post(post).build();
        PostComment my_second_review = PostComment.builder().title("My second review").post(post).build();
        PostComment my_third_review = PostComment.builder().title("My third review").post(post).build();

        persist(em, my_first_review);
        persist(em, my_second_review);
        persist(em, my_third_review);

        // Get all postcomments is also easy in this solution:
        // - post.comments is not available, but
        // - we can write a simple query for that:
        List<PostComment> comments = em.createQuery(
                "select pc " +
                        "from PostComment pc " +
                        "where pc.post.id = :postId", PostComment.class)
                .setParameter("postId", post.getId())
                .getResultList();

        comments.forEach(System.out::println);
    }

    public App() { super(manyToOneUni); }

    public static void main(String[] args) { new App().start(); }

}
