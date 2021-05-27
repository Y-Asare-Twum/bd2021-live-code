package org.example.resources;

import org.example.domain.Contact;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/users")
public class UsersResource {

    @Inject
    private Logger log; // WELD is DI container

    // TODO:
    // private final List<Contact> contacts = new ArrayList<>(List.of(
    //         cb.name("Bram").age(41).id(1L).build(),
    //         cb.name("Joop").age(23).id(2L).build(),
    //         cb.name("Mieke").age(45).id(3L).build()
    // ));

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Contact post(Contact c) {
        // TODO
        return c;
    }

}
