package org.example.resources;

import org.example.domain.Contact;
import org.example.domain.IDao;
import org.example.domain.Job;
import org.example.util.ContactDAO;
import org.example.util.JobDAO;
import org.example.util.JsonResource;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

import static org.example.util.Response.badRequest;

//  To make subresources work withOpenAPI, use mpOpenAPI >= 2.0 (and liberty >= 21)
@Dependent
public class ContactResource implements JsonResource {

    @Inject @ContactDAO
    private IDao<Contact> contactDao;

    @Inject @JobDAO
    private IDao<Job> jobDao;

    @GET
    public Contact get(@PathParam("id") Long id) {
        // Optional<Contact> optionalContact = this.dao.getById(id);
        // if(optionalContact.isPresent())
        //     return optionalContact.get();
        // else {
        //     throw badRequest(id);
        // }

        // Or shorter:
        return this.contactDao.getById(id)
                .orElseThrow(() -> badRequest(id));
    }

    @DELETE
    public void delete(@PathParam("id") Long id) {
        this.contactDao.delete(id);
    }

    @GET @Path("jobs")
    public List<Job> getJobs() {
        return jobDao.get(null);
    }

    // @Inject
    // public void setJobDao(JobDao jobDao) { this.jobDao = jobDao; }
    //
    // @Inject
    // public void setContactDao(ContactDao contactDao) { this.contactDao = contactDao; }
}
