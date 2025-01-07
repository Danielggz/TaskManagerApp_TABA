/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.taskmanagerapp.resources;

import jakarta.persistence.Convert;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

/**
 * REST Web Service
 *
 * @author Daniel García
 */
@Provider
public class AuthenticationResource implements ContainerRequestFilter
{
    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String AUTH_HEADER_PREFIX = "Basic";
    private static final String SECURED_URL_PREFIX = "projects"; //the prefix that should be secured is the main projects
    
    //Implement abstract method filter
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //Get URI path information that contains "projects"
        if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
            //Get headers
            List<String> authHeader = requestContext.getHeaders().get(AUTH_HEADER_KEY);
            if(authHeader != null && !authHeader.isEmpty()){
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
                
                //Assign tokens for username and password
                String decodedString = new String(Base64.getMimeDecoder().decode(authToken));
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                
                //If username and password matches the values, continue to resource
                if("admin".equals(username) && "Abc123.".equals(password)){
                    return;
                }
            }
            //Respond with forbidden key 403 if the authorization is not correct or is missing
            Response unauthorizedStatus = Response.status(Response.Status.FORBIDDEN).entity("User or password incorrect. Please try again").build();
            requestContext.abortWith(unauthorizedStatus);
        }
    }
}
