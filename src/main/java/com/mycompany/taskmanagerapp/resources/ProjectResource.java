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
    public Project getProjectXML(@PathParam("projectId") int projectId) {
        return projectService.getProject(projectId);
    }
    
    //Retrieve a project by id (JSON)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectJSON(@PathParam("projectId") int projectId) {
        return projectService.getProject(projectId);
    }
    
    //Update project
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateProj")
    public Project updateProject(Project updtProj) {
        System.out.println(updtProj);
	return projectService.updateProject(updtProj);
    }
    
    //Delete project
    @DELETE
    @Path("/deleteProj/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project deleteProject(@PathParam("projectId") int projectId){
        return projectService.deleteProject(projectId);
    }
    
    //Assign tasks to a project
    @POST
    @Path("/assignTasks/{projectId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project assignTasks(@PathParam("projectId") int projId, List<Task> listofTasks) {
        return projectService.assignTasks(projId, listofTasks);
    }
    
    //Retrieve all tasks by status
    @GET
    @Path("/tasksByStatus/{taskStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasksByStatus(@PathParam("taskStatus") String taskStatus) {
        return projectService.getAllTasksByStatus(taskStatus);
    }
    
    //Get tasks resource
    @Path("/{projectId}/tasks")
    public TaskResource getTasksByProjectResource() {
	return new TaskResource();
    }
    
}
