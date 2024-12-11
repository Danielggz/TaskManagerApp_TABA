/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.taskmanagerapp.resources;

import com.mycompany.taskmanagerapp.models.Task;
import com.mycompany.taskmanagerapp.models.Task;
import com.mycompany.taskmanagerapp.services.TaskService;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
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
@Path("tasks")
@RequestScoped
public class TaskResource {
    
    TaskService taskService = new TaskService();
    /**
     * Creates a new instance of TasksResource
     */
    public TaskResource() {
    }

    //Create task
    @POST
    @Path("/newTask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(Task projPost) {
        return taskService.createTask(projPost);
    }
    //Retrieve all tasks (XML)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Task> getTasksXML() {
        return taskService.getAllTasks();
    }
    //Retrieve all tasks (JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasksJSON() {
        return taskService.getAllTasks();
    }
    //Retrieve task (XML)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_XML)
    public Task getTaskXML(@PathParam("projId") int projId) {
        return taskService.getTask(projId);
    }
    //Retrieve task (JSON)
    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskJSON(@PathParam("projId") int projId) {
        return taskService.getTask(projId);
    }
    //Update task
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateProj/{projectId}")
    public Task updateTask(Task updtProj) {
	return taskService.updateTask(updtProj);
    }
    //Delete task
    @GET
    @Path("/deleteProj/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task deleteTask(int idProj){
        return taskService.deleteTask(idProj);
    }
}
