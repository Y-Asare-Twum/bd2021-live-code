package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.IContactDao;
import org.example.domain.Job;
import org.example.util.JsonResource;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

import static org.example.util.Response.badRequest;

// @Vetoed
// @Dependent
public class ContactResource implements JsonResource {

    @Inject //             @EJB is de oude @Inject, EN het kan alleen EJBs injecten, dat zijn classes met super powers
    private Logger log; // WELD is DI container

    @Inject
    private IContactDao dao;

    private Long id;

    public ContactResource init(Long id) {
        this.id = id;
        return this;
    }

    @GET
    public Contact get() {
        return this.dao.getById(id)
                .orElseThrow(() -> badRequest(id));
    }

    @DELETE
    public void delete() {
        this.dao.delete(id);
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
