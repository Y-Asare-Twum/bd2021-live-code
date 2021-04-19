package org.example;

// javax: java eXtension

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Person {

    @Id @GeneratedValue
    private long id;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
