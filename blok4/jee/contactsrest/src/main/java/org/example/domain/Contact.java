package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.CascadeType.MERGE;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table
@NamedQueries({
        @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
        @NamedQuery(name = "Contact.findByQ", query = "SELECT c FROM Contact c WHERE c.surname LIKE :q OR c.firstName like :q"),
        @NamedQuery(name = "Contact.find", query = "SELECT c FROM Contact c WHERE c.id=:id")
})
@XmlRootElement
public class Contact {

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    @Column(name = "name")
    private String surname;

    private String email;

    private int age;

    @ManyToOne(cascade = MERGE/*, fetch = LAZY*/) // On merge cascade
    private Job job; // FK

}
