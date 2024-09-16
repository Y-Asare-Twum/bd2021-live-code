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
        @NamedQuery(name = "Laptop.findAll", query = "SELECT e FROM Laptop e"),
        @NamedQuery(name = "Laptop.find", query = "SELECT e FROM Laptop e WHERE e.id=:id")
})
public class Laptop implements Identifiable<Long> {

    @Id @GeneratedValue
    private Long id;
    private String brand;

}
