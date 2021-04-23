package org.example.post.onetomany.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    private long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default // Builder should take default value (new ArrayList), otherwise builder sets comments to null
    private List<PostComment> comments = new ArrayList<>();

}
