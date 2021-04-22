package org.example.post.onetomany.uni;

import org.example.Em;

import javax.persistence.EntityManager;

public class App {

    private static final EntityManager em = Em.em;

    public static void main(String[] args) {
        Post post = Post.builder().title("first").build();

        post.getComments().add(new PostComment("My first review"));
        post.getComments().add(new PostComment("My second review"));
        post.getComments().add(new PostComment("My third review"));

        persist(post);
    }

    private static void persist(Post post) {
        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
    }
}
