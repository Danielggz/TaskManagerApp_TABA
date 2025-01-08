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
    
    public Task createTask(Task newT, int projId){
        Project p = null;
        try{
           p = projectList.get(projId-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        taskList.add(newT);
        p.addTask(newT);
        return newT;
    }
    
    public List<Task> getAllTasks(int projId){
        List<Task> listT = null;
        try{
           listT = projectList.get(projId-1).getListTasks();
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return listT;
    }
    
    public Task getTask(int projId, int idTask){
        Task t = null;
        try{
           t = projectList.get(projId-1).getListTasks().get(idTask-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return t;
    }
    
    public List<Task> getTaskByStatus(int projId, String status){
        List<Task> listT = null;
        try{
           listT = projectList.get(projId-1).getListTasks();
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        //Create list with tasks that have the status requested
        List<Task> tasksByStatus = new ArrayList<>();
        if(listT != null){
            for(Task t: projectList.get(projId-1).getListTasks()){
                if(t.getStatus().equals(status))
                tasksByStatus.add(t);
            }
        }
        return tasksByStatus;
    }
    
    public Task updateTask(int projId, Task t){
        Project p = null;
        try{
           p = projectList.get(projId-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return p.getListTasks().set(t.getId()-1, t);
    }
    
    public Task updateStatus(int projId, int taskId, String status){
        Task t = null;
        try{
           t = projectList.get(projId-1).getListTasks().get(taskId-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        //Change status of specified task
        projectList.get(projId-1).getListTasks().get(taskId-1).setStatus(status);
        return t;
    }
    
    public Task deleteTask(int projId, int idTask){
        Task t = null;
        try{
           t = projectList.get(projId-1).getListTasks().remove(idTask-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return t;
    }
}
