package org.example.post.onetomany.uni;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Post {

    @Id @GeneratedValue
    private long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PostComment> comments = new ArrayList<>();

}
