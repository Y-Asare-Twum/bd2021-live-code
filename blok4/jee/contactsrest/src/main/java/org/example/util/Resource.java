package org.example.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Produces({APPLICATION_JSON, APPLICATION_XML})
@Consumes({APPLICATION_JSON, APPLICATION_XML})
public interface Resource {
}
