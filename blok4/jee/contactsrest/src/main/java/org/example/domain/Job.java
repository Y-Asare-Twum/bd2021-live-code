package org.example.domain;

// javax: java eXtension

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Job.findAll", query = "SELECT e FROM Job e"),
        @NamedQuery(name = "Job.findByQ", query = "SELECT e FROM Job e WHERE e.title LIKE :q")
})
@XmlRootElement
public class Job {

    @Id @GeneratedValue
    private Long id;
    private String title;

}
