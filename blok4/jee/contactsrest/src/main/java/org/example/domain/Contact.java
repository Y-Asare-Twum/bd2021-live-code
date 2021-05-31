package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "Person")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
        @NamedQuery(name = "Contact.findByQ", query = "SELECT c FROM Contact c WHERE c.surname LIKE :q OR c.firstName like :q"),
        @NamedQuery(name = "Contact.find", query = "SELECT c FROM Contact c WHERE c.id=:id")
})
public class Contact {
    @Id @GeneratedValue
    private Long id;

    private String firstName;

    @Column(name = "name")
    private String surname;

    private String email;

    private int age;

}
