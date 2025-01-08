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
import jakarta.ws.rs.core.Response;
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
    public Response createTask(Task projPost, @PathParam("projectId") int projId) {
        Task newT = taskService.createTask(projPost, projId);
        if(newT != null){
            return Response.ok(newT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("The task could not be created. Please try again").build();
    }
    
    //Retrieve all tasks (XML)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getTasksXML(@PathParam("projectId") int projId) {
        List<Task> listT = taskService.getAllTasks(projId);
        if(!listT.isEmpty()){
            return Response.ok(listT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity("There are not tasks yet. To add a new task use the tag /newTask").build();
    }
    
    //Retrieve all tasks (JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTasksJSON(@PathParam("projectId") int projId) {
        List<Task> listT = taskService.getAllTasks(projId);
        if(!listT.isEmpty()){
            return Response.ok(listT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity("There are not tasks yet. To add a new task use the tag /newTask").build();
    }
    
    //Retrieve task (XML)
    @GET
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getTaskXML(@PathParam("projectId") int projId, @PathParam("taskId") int taskId) {
        Task t = taskService.getTask(projId,taskId);
        if(t != null){
            return Response.ok(t, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("There is no task with that id. Please try again").build();
    }
    
    //Retrieve task (JSON)
    @GET
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskJSON(@PathParam("projectId") int projId, @PathParam("taskId") int taskId) {
        Task t = taskService.getTask(projId,taskId);
        if(t != null){
            return Response.ok(t, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("There is no task with that id. Please try again").build();
    }
    
    //Retrieve task by Status
    @GET
    @Path("getByStatus/{taskStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskByStatus(@PathParam("projectId") int projId, @PathParam("taskStatus") String taskStatus) {
        List<Task> listT = taskService.getTaskByStatus(projId, taskStatus);
        if(!listT.isEmpty()){
            return Response.ok(listT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("There is no task with that id. Please try again").build();
    }
    
    //Update task
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateTask")
    public Response updateTask(@PathParam("projectId") int projId, Task updtTask) {
        Task modT = taskService.updateTask(projId, updtTask);
        if(modT != null){
            return Response.ok(modT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).entity("The task could not be modified. Please try again").build();
    }
    
    //Update status of a task
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateTaskStatus/{taskId}/{newStatus}")
    public Response updateTaskStatus(@PathParam("projectId") int projId, @PathParam("taskId") int taskId, @PathParam("newStatus") String newStatus) {
	Task t = taskService.updateStatus(projId, taskId, newStatus);
        if(t != null){
            return Response.ok(t, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The task could not be found. Please try again").build();
    }
    
    //Delete task
    @GET
    @Path("/deleteTask/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTask(@PathParam("projectId") int projId, @PathParam("taskId") int taskId){
        Task delT = taskService.deleteTask(projId, taskId);
        if(delT != null){
            return Response.ok(delT, MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("The task to delete does not exist. Please try again").build();
    }
}
