/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.services;

import com.mycompany.taskmanagerapp.databases.Database;
import com.mycompany.taskmanagerapp.models.Project;
import com.mycompany.taskmanagerapp.models.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel García
 * 11/12/2024
 */
public class TaskService {
    Database db = new Database();
    private List<Task> taskList = db.getTasks();
    private List<Project> projectList = db.getProjects();
    
    public TaskService(){
        
    }
    
    public List<Task> createTask(Task newT, int projId){
        taskList.add(newT);
        projectList.get(projId-1).addTask(newT);
        return projectList.get(projId-1).getListTasks();
    }
    
    public List<Task> getAllTasks(int projId){
        return projectList.get(projId-1).getListTasks();
    }
    
    public Task getTask(int projId, int idTask){
        return projectList.get(projId-1).getListTasks().get(idTask-1);
    }
    
    public List<Task> getTaskByStatus(int projId, String status){
        //Create list with tasks that have the status requested
        List<Task> tasksByStatus = new ArrayList<>();
        if(projectList.get(projId-1).getListTasks() != null){
            for(Task t: projectList.get(projId-1).getListTasks()){
                if(t.getStatus().equals(status))
                tasksByStatus.add(t);
            }
        }
        return tasksByStatus;
    }
    
    public Task updateTask(int projId, Task t){
        return projectList.get(projId-1).getListTasks().set(t.getId()-1, t);
    }
    
    public Task updateStatus(int projId, int taskId, String status){
        //Change status of specified task
        System.out.println("NEW STATUS: " + status);
        projectList.get(projId-1).getListTasks().get(taskId).setStatus(status);
        return projectList.get(projId-1).getListTasks().get(taskId);
    }
    
    public Task deleteTask(int projId, int idTask){
        return projectList.get(projId-1).getListTasks().remove(idTask-1);
    }
}
