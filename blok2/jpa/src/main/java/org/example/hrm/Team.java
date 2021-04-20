package org.example.hrm;

// javax: java eXtension

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Identifiable;

import javax.persistence.*;
import java.util.Set;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT e FROM Team e"),
        @NamedQuery(name = "Team.find", query = "SELECT e FROM Team e WHERE e.id=:id")
})
public class Team implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;
    private String yell;

    @OneToMany(mappedBy = "scrumteam")
    private Set<Person> members;
}
