package org.example.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.example.domain.Contact;
import org.example.domain.IDao;
import org.example.util.ContactDAO;
import org.example.util.JsonResource;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/* @RequestScoped */
@Path("/contacts")
public class ContactsResource implements JsonResource {

    @Inject //             @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container
    //                     bovenstaande regel is het zogenaamde injection point

    @Inject @ContactDAO// new fashioned @EJB
    private IDao<Contact> dao; // talk to an interface, not to an implementation

    @Inject
    private ContactResource contactResource;

    // uri: .../contacts
    //      .../contacts?name=Bram
    @GET
    @Operation(description = "Gets all contacts or filtered by q.")
    // Add API documentation for mpOpenAPI, see https://openliberty.io/blog/2018/05/22/microprofile-openapi-intro.html
    // and for a quick overview: https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc#quick-overview-of-annotations.
    public List<Contact> get(@Parameter(description = "Search on firstname and/or surname")
                             @QueryParam("q") String q) {
        if (q == null) {
            log.debug("Geen zoekparameter meegegeven, geef alle contacts terug.");
        } else {
            log.debug("Zoekparameter {} meegegeven, geef gefilterde contacts terug.", q);
        }

        return this.dao.get(q);
    }

    @POST
    public Contact post(Contact c) {
        return this.dao.add(c);
    }

    // ...../contacts/1
    // DON'T annotate Forward to subresource with http method like GET/POST/...!
    @Path("{id}")
    public ContactResource getById(@PathParam("id") Long id) {
        return this.contactResource;
    }

    /*@GET @Path("connected")
    public Response conn() {
        Contact jans = Contact.builder().id(100L).firstName("BRAAAAAM!").surname("Jans").email("fsdfdf@kfjdsf.com").build();
        ContactDto dto = ContactDto.of(jans);

        return Response.status(200)
                .entity(dto) // response body
                .links(Link.valueOf("hello!"))
                .build();
    }*/
}
