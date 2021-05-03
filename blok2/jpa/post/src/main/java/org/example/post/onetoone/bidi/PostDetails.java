package org.example.post.onetoone.bidi;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString(exclude = "post")
public class PostDetails { // child side
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime createdOn;

    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    private Post post;

}
