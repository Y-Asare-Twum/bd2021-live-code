package org.example.hrm;

// javax: java eXtension

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Identifiable;

import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Person.find", query = "SELECT p FROM Person p WHERE p.id=:id")
})
public class Person implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;

}
