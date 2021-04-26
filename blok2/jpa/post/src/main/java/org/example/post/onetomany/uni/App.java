package org.example.post.onetomany.uni;

import org.example.AppInit;

import static org.example.Config.*;

public class App extends AppInit {

    private void start() {
        Post post = Post.builder().title("first").build();

        post.getComments().add(PostComment.builder().title("My first review").build());
        post.getComments().add(PostComment.builder().title("My second review").build());
        post.getComments().add(PostComment.builder().title("My third review").build());

        persist(em, post);
        // This results in:
        // - three tables
        // - seven INSERTs

        // Same logic for remove:
        post.getComments().remove(0);
        merge(em, post);
        // This results in:
        // - update on post
        // - delete on postcomment (because orphanRemoval=true)

        // Possible improvements:
        // 1) Use a @JoinColumn on Post.comments to prevent additional table.
        // 2) Make relationship bidi.
        // 3) Use ManyToOne uni and use query to get all comments from post.

    }

    public App() { super(oneToManyUni); }

    public static void main(String[] args) { new App().start(); }

}
