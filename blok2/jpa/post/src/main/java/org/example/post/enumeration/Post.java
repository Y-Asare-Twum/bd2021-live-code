package org.example.post.enumeration;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Enumerated(EnumType.STRING) // EnumType is optional: not most efficient way.
    private Tag rootTag;

    @ElementCollection // onetomany to enum
    @Singular
    private Set<Tag> tags;

    @OneToMany
    @Singular
    private Set<Category> categories = new HashSet<>();

}

