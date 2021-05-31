package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.ContactDao;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import static java.lang.String.format;

@Path("/contacts") // @RequestScoped implicitly
public class ContactsResource implements JsonResource {

    @Inject //             @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container
    //                     bovenstaande regel is het zogenaamde injection point

    @Inject
    private ContactDao dao;

    // uri: .../contacts
    //      .../contacts?name=Bram

    @GET
    public List<Contact> get(@QueryParam("q") String q) {
        if (q == null) {
            log.debug("Geen zoekparameter meegegeven, geef alle contacts terug.");
        } else {
            log.debug("Zoekparameter {} meegegeven, geef gefilterde contacts terug.", q);
        }

        return this.dao.get(q);
    }

    // ...../contacts/1

    @GET @Path("{id}")
    public Contact getById(@PathParam("id") Long id) {
        return this.dao.getById(id)
                .orElseThrow(() -> new BadRequestException(format("Contact with id %s not found.", id)));
    }

    @POST
    public Contact post(Contact c) {
        return this.dao.add(c);
    }

}
