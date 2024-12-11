/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.taskmanagerapp.resources;

import com.mycompany.taskmanagerapp.models.Project;
import com.mycompany.taskmanagerapp.services.ProjectService;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Web Service
 *
 * @author Daniel García
 */
@Path("generic")
@RequestScoped
public class ProjectResource {
    
    ProjectService projectService = new ProjectService();
    
    public ProjectResource() {
    }
    
    //Create project
    @POST
    @Path("/newProject")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project createProject(Project projPost) {
        return projectService.createProject(projPost);
    }
    
    //Retrieve all projects (XML)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Project> getProjectsXML() {
        return projectService.getAllProjects();
    }
    
    //Retrieve all projects (JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjectsJSON() {
        return projectService.getAllProjects();
    }
    
    //Retrieve a project by id (XML)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_XML)
    public Project getProjectXML(@PathParam("projId") int projId) {
        return projectService.getProject(projId);
    }
    
    //Retrieve a project by id (JSON)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectJSON(@PathParam("projId") int projId) {
        return projectService.getProject(projId);
    }
    
    //Update project
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateProj/{projectId}")
    public Project updateProject(Project updtProj) {
	return projectService.updateProject(updtProj);
    }
    
    //Delete project
    @GET
    @Path("/deleteProj/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project deleteProject(int idProj){
        return projectService.deleteProject(idProj);
    }
    
    @Path("/{projectId}/tasks")
    public TaskResource getCommentsResource() {
	System.out.println("Getting comments subresoruces...");
	return new TaskResource();
    }
    
}
