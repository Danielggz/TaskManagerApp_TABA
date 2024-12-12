/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.services;

import com.mycompany.taskmanagerapp.databases.Database;
import com.mycompany.taskmanagerapp.models.Project;
import com.mycompany.taskmanagerapp.models.Task;
import java.util.List;

/**
 * @author Daniel García
 * 11/12/2024
 */
public class TaskService {
    Database db = new Database();
    private List<Task> taskList = db.getTasks();
    private List<Project> projectList = db.getProjects();
    
    public List<Task> createTask(Task newT, int projId){
        taskList.add(newT);
        projectList.get(projId).addTask(newT);
        return projectList.get(projId).getListTasks();
    }
    
    public List<Task> getAllTasks(int projId){
        return projectList.get(projId).getListTasks();
    }
    
    public Task getTask(int projId, int idTask){
        return projectList.get(projId).getListTasks().get(idTask-1);
    }
    
    public Task updateTask(int projId, Task t){
        return projectList.get(projId).getListTasks().set(t.getId()-1, t);
    }
    
    public Task deleteTask(int projId, int idTask){
        return projectList.get(projId).getListTasks().remove(idTask-1);
    }
}
