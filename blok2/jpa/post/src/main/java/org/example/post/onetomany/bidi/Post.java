package org.example.post.onetomany.bidi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    private long id;

    private String title;

    @OneToMany(cascade = ALL, mappedBy = "post", fetch = LAZY)
    @Builder.Default // Builder should take default value (new ArrayList), otherwise builder sets comments to null
    private List<PostComment> comments = new ArrayList<>();

    // Update both sides of the bidirectional relationship
    public void addComment(PostComment pc) {
        this.comments.add(pc);
        pc.setPost(this);
    }

}

