package org.example.post.onetomany.bidi;

import org.example.AppInit;

import javax.persistence.EntityManager;

import static org.example.Config.*;

public class App extends AppInit {

    private static final EntityManager em = em(oneToManyBidi);

    private void start() {
        Post post = Post.builder().title("first").build();

        post.addComment(new PostComment("My first review"));
        post.addComment(new PostComment("My second review"));
        post.addComment(new PostComment("My third review"));

        persist(em, post);
        // This results in:
        // - just two tables
        // - just one SQL statement for each persisted PostComment entity

        // Same logic for update/remove:
        post.removeComment(post.getComments().get(0));
        merge(em, post);
        // This results in:
        // - only one delete on postcomment (because orphanRemoval=true)
    }

    public App() { super(oneToManyBidi); }

    public static void main(String[] args) { new App().start(); }

}
