/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.taskmanagerapp.resources;

import com.mycompany.taskmanagerapp.models.Task;
import com.mycompany.taskmanagerapp.services.TaskService;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
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
public class TaskResource {
    
    TaskService taskService = new TaskService();
    
    //Create task
    @POST
    @Path("/newTask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> createTask(Task projPost, @PathParam("projectId") int projId) {
        return taskService.createTask(projPost, projId);
    }
    
    //Retrieve all tasks (XML)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Task> getTasksXML(@PathParam("projectId") int projId) {
        return taskService.getAllTasks(projId);
    }
    
    //Retrieve all tasks (JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasksJSON(@PathParam("projectId") int projId) {
        return taskService.getAllTasks(projId);
    }
    
    //Retrieve task (XML)
    @GET
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_XML)
    public Task getTaskXML(@PathParam("projectId") int projId, @PathParam("taskId") int taskId) {
        return taskService.getTask(projId,taskId);
    }
    
    //Retrieve task (JSON)
    @GET
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskJSON(@PathParam("projectId") int projId, @PathParam("taskId") int taskId) {
        return taskService.getTask(projId,taskId);
    }
    
    //Update task
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateTask")
    public Task updateTask(@PathParam("projectId") int projId, Task updtTask) {
	return taskService.updateTask(projId, updtTask);
    }
    
    //Update status of a task
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateTaskStatus/{taskId}/{newStatus}")
    public Task updateTaskStatus(@PathParam("projectId") int projId, @PathParam("taskId") int taskId, @PathParam("newStatus") String newStatus) {
	return taskService.updateStatus(projId, taskId, newStatus);
    }
    
    //Delete task
    @GET
    @Path("/deleteTask/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task deleteTask(@PathParam("projectId") int projId, @PathParam("taskId") int taskId){
        return taskService.deleteTask(projId, taskId);
    }
}
