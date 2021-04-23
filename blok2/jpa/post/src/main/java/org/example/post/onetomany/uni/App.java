package org.example.post.onetomany.uni;

import javax.persistence.EntityManager;

import static org.example.Em.*;

public class App {

    private static final EntityManager em = em(oneToManyUni);

    public static void main(String[] args) {
        Post post = Post.builder().title("first").build();

        post.getComments().add(new PostComment("My first review"));
        post.getComments().add(new PostComment("My second review"));
        post.getComments().add(new PostComment("My third review"));

        persist(em, post);
    }

}
