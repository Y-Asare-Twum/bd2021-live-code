package org.example.resources;

import org.example.domain.User;
import org.example.util.JsonResource;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/users")
public class UsersResource implements JsonResource {

    @Inject
    private Logger log;

    @POST
    public User post(User u) {
        // TODO
        return u;
    }

}
