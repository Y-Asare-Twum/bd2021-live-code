package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c"),
        @NamedQuery(name = "User.findByQ", query = "SELECT c FROM User c WHERE c.username like :q")
})
@XmlRootElement
public class User {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
