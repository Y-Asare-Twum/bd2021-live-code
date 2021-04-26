package org.example.post.manytoone.bidi;

import javax.persistence.EntityManager;

import static org.example.Config.*;

public class App {

    private static final EntityManager em = em(manyToOneBidi);

    public static void main(String[] args) {
        Post post = Post.builder().title("first").build();

        post.addComment(new PostComment("My first review"));
        post.addComment(new PostComment("My second review"));
        post.addComment(new PostComment("My third review"));

        persist(em, post);
    }

}
