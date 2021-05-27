package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Contact {
    private Long id;

    private String firstName;
    private String surname;
    private String email;

    private int age;

}
