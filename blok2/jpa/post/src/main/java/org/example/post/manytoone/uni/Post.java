package org.example.post.manytoone.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

}

