package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.ws.rs.core.Link;

@Value @AllArgsConstructor
// @XmlRootElement
public class ContactDto {

    public long id;

    public String firstName;
    public String surname;
    public String email;

    public ContactDto() {
        this.id = 0;
        this.firstName = "";
        this.surname = "";
        this.email = "";
    }

    // @XmlElement
    public Link self = Link.valueOf("hello");

    public static ContactDto of(Contact c) {
        return new ContactDto(c.getId(), c.getFirstName(), c.getSurname(), c.getEmail());
    }

}
