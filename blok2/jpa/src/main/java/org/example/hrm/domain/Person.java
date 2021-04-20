package org.example.hrm.domain;

// javax: java eXtension

import lombok.*;
import org.example.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Person.find", query = "SELECT p FROM Person p WHERE p.id=:id")
})
public class Person implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;

    @Size(max = 200)
    private String name;

    private int age;

    @ManyToOne(cascade = MERGE) // On merge cascade
    private Job job; // FK

    @ManyToOne(cascade = MERGE) // On merge cascade
    @ToString.Exclude
    private Team scrumteam; // FK

    @OneToMany/*(fetch = FetchType.LAZY)*/
    private Set<Laptop> laptops;

    // BiDi relationship: update other side of relationship
    public void setScrumteam(Team scrumteam) {
        this.scrumteam = scrumteam;
        scrumteam.getMembers().add(this);
    }
}
