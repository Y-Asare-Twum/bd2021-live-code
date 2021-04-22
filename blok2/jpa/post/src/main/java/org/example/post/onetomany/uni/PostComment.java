package org.example.post.onetomany.uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostComment {

    @Id @GeneratedValue
    private long id;

    private String title;

    public PostComment() {
    }

    public PostComment(String title) {
        this.title = title;
    }
}
