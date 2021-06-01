package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.IContactDao;
import org.example.domain.Job;
import org.example.util.JsonResource;
import org.slf4j.Logger;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

import static java.lang.String.format;

@Vetoed
public class ContactResource implements JsonResource {

    private Long id;

    private IContactDao dao;

    public ContactResource() { }

    public ContactResource(Long id, IContactDao dao) {
        this.id = id;
        this.dao = dao;
    }

    @Inject //             @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container

    @GET
    // @Produces(MediaType.APPLICATION_XML)
    public Contact get() {
        return this.dao.getById(id)
                .orElseThrow(() -> new BadRequestException(format("Contact with id %s not found.", id)));
    }

    @GET @Path("jobs")
    public List<Job> getLaptops() {
        return List.of(
                Job.builder().id(1L).title("Java programmer").build(),
                Job.builder().id(2L).title("PHP programmer").build(),
                Job.builder().id(3L).title("Dad").build()
        );
    }
}
