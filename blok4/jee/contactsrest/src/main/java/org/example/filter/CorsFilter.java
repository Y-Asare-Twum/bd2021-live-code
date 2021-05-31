package org.example.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

// @Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        MultivaluedMap<String, Object> headers = response.getHeaders();

        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Allow-Credentials", "true"); // to return jwt in Authorization header
        headers.add("Access-Control-Allow-Headers", "origin, authorization"); // content-type, accept too?
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE"); // OPTIONS, HEAD not needed?
    }
}
