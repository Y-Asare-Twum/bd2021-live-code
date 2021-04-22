package org.example.hrm.domain;

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
        @NamedQuery(name = "Job.findAll", query = "SELECT e FROM Job e"),
        @NamedQuery(name = "Job.find", query = "SELECT e FROM Job e WHERE e.id=:id")
})
public class Job implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;
    private String title;

}
