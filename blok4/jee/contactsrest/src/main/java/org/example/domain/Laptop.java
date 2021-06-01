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
        @NamedQuery(name = "Laptop.findAll", query = "SELECT e FROM Laptop e"),
        @NamedQuery(name = "Laptop.find", query = "SELECT e FROM Laptop e WHERE e.id=:id")
})
@XmlRootElement
public class Laptop {

    @Id @GeneratedValue
    private Long id;
    private String brand;
}
