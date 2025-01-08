/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.taskmanagerapp.resources;

import com.mycompany.taskmanagerapp.models.Project;
import com.mycompany.taskmanagerapp.models.Task;
import com.mycompany.taskmanagerapp.services.ProjectService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * REST Web Service
 *
 * @author Daniel García
 */
@Path("/projects")
public class ProjectResource {
    
    ProjectService projectService = new ProjectService();
    
    //Create project
    @POST
    @Path("/newProject")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(Project projPost) {
        Project newP = projectService.createProject(projPost);
        if(newP != null){
            return Response.ok(newP, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The new project is not correct. Please try again").build();
    }
    
    //Retrieve all projects (XML)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getProjectsXML() {
        List<Project> listProj = projectService.getAllProjects();
        if(!listProj.isEmpty()){
            return Response.ok(listProj, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity("There are no projects yet. use the tag /newProject to create one").build();
    }
    
    //Retrieve all projects (JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectsJSON() {
        List<Project> listProj = projectService.getAllProjects();
        if(!listProj.isEmpty()){
            return Response.ok(listProj, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity("There are no projects yet. use the tag /newProject to create one").build();
    }
    
    //Retrieve a project by id (XML)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getProjectXML(@PathParam("projectId") int projectId) {
        Project p = projectService.getProject(projectId);
        if(p != null){
            return Response.ok(p, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The project searched does not exist. Please try again").build();
    }
    
    //Retrieve a project by id (JSON)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectJSON(@PathParam("projectId") int projectId) {
        Project p = projectService.getProject(projectId);
        if(p != null){
            return Response.ok(p, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The project searched does not exist. Please try again").build();
    }
    
    //Update project
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateProj")
    public Response updateProject(Project updtProj) {
        Project p = projectService.updateProject(updtProj);
        if(p != null){
            return Response.ok(p, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The project to update does not exist. Please try again").build();
    }
    
    //Delete project
    @DELETE
    @Path("/deleteProj/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProject(@PathParam("projectId") int projectId){
        Project delP = projectService.deleteProject(projectId);
        if(delP != null){
            return Response.ok(delP, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The project to delete does not exist. Please try again").build();
    }
    
    //Assign tasks to a project
    @POST
    @Path("/assignTasks/{projectId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignTasks(@PathParam("projectId") int projId, List<Task> listofTasks) {
        Project p = projectService.assignTasks(projId, listofTasks);
        if(p != null){
            return Response.ok(p, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The project to assign task does not exist. Please try again").build();
    }
    
    //Retrieve all tasks by status
    @GET
    @Path("/tasksByStatus/{taskStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTasksByStatus(@PathParam("taskStatus") String taskStatus) {
        List<Task> listT = projectService.getAllTasksByStatus(taskStatus);
        if(!listT.isEmpty()){
            return Response.ok(listT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity("There are no tasks with that status").build();
    }
    
    //Get tasks resource
    @Path("/{projectId}/tasks")
    public TaskResource getTasksByProjectResource() {
	return new TaskResource();
    }
    
}
