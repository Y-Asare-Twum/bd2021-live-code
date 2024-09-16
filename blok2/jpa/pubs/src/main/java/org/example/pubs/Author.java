package org.example.pubs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Identifiable;

import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Authors")
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
        @NamedQuery(name = "Author.find", query = "SELECT a FROM Author a WHERE a.id=:id")
})
public class Author implements Identifiable<String> {

    @Id @GeneratedValue
    @Column(name = "AU_ID")
    private String id;

    @Column(name = "AU_LNAME")
    private String lastname;

}
