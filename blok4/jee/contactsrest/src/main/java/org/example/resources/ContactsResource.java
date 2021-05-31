package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.IContactDao;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.lang.String.format;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/contacts") // @RequestScoped implicitly
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ContactsResource implements JsonResource {

    @Inject //             @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container
    //                     bovenstaande regel is het zogenaamde injection point

    @Inject // new fashioned @EJB
    private IContactDao dao; // talk to an interface, not to an implementation

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

    @GET @Path("/connected")
    public Response conn() {
        return Response.status(200)
                .type(APPLICATION_JSON)
                .entity(Contact.builder().firstName("BRAAAAAM!").build()) // response body
                .links(Link.valueOf("hello!"))
                .build();
    }
}
