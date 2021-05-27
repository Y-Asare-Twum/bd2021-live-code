package org.example.resources;

import org.example.domain.Contact;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/contacts")
public class ContactsResource {

    @Inject // @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container

    private final Contact.ContactBuilder cb = Contact.builder();

    private final List<Contact> contacts = new ArrayList<>(List.of(
            cb.name("Bram").age(41).id(1L).build(),
            cb.name("Joop").age(23).id(2L).build(),
            cb.name("Mieke").age(45).id(3L).build()
    ));

    // uri: .../contacts
    //      .../contacts?name=Bram

    @GET
    @Produces(APPLICATION_JSON)
    public List<Contact> get(@QueryParam("name") String n) {
        if (n == null) {
            log.debug("Geen zoekparameter meegegeven, geef alle contacts terug.");
        } else {
            log.debug("Zoekparameter {} meegegeven, geef gefilterde contacts terug.", n);
        }

        return n == null ?
                this.contacts :
                contacts.stream()
                        .filter(c -> c.getName().contains(n))
                        .collect(toList());
    }

    // ...../contacts/1

    @GET @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Contact getById(@PathParam("id") Long id) {
        return this.contacts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BadRequestException(format("Contact with id %s not found.", id)));
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Contact post(Contact c) {
        this.contacts.add(c);
        return c;
    }

}
