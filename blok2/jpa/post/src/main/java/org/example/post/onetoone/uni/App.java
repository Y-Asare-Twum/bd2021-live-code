package org.example.post.onetoone.uni;

import org.example.AppInit;

import static java.time.LocalDateTime.now;
import static org.example.Config.*;

public class App extends AppInit {

    // See https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/

    private void start() {
        Post post = Post.builder().title("first").build();
        PostDetails details = PostDetails.builder().post(post).createdBy("Me").createdOn(now()).build();
        persist(em, details);

        // results in one SELECT, no details fetched since uni
        post = find(em, post.getId(), Post.class);

        // results in one SELECT, find by POST id
        PostDetails postDetails = find(em, post.getId(), PostDetails.class);
        System.out.println(postDetails);
    }

    public App() { super(oneToOneUni); }

    public static void main(String[] args) { new App().start(); }

}
