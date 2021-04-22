package org.example.post.onetomany.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<PostComment> comments = new ArrayList<>();

}
