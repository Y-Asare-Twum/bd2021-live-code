package org.example.post.onetomany.uni;

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

    @OneToMany(cascade = ALL, fetch = LAZY, orphanRemoval = true)
    @JoinColumn(name = "postId")
    @Builder.Default // Builder should take default value (new ArrayList), otherwise builder sets comments to null (recommended in Uni, mandatory in BiDi)
    private List<PostComment> comments = new ArrayList<>();

}
