package org.example.post.manytoone.uni;

import javax.persistence.EntityManager;

import static org.example.Em.*;

public class App {

    private static final EntityManager em = em(manyToOneUni);

    public static void main(String[] args) {
        Post post = Post.builder().title("first").build();

        PostComment my_first_review = PostComment.builder().title("My first review").post(post).build();
        PostComment my_second_review = PostComment.builder().title("My second review").post(post).build();
        PostComment my_third_review = PostComment.builder().title("My third review").post(post).build();

        persist(em, my_first_review);
        persist(em, my_second_review);
        persist(em, my_third_review);
    }

}
