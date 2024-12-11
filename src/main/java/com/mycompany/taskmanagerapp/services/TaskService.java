/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.services;

import com.mycompany.taskmanagerapp.databases.Database;
import com.mycompany.taskmanagerapp.models.Task;
import java.util.List;

/**
 * @author Daniel García
 * 11/12/2024
 */
public class TaskService {
    Database db = new Database();
    private List<Task> taskList = db.getTasks();
    
    public Task createTask(Task newT){
        taskList.add(newT);
        return newT;
    }
    
    public List<Task> getAllTasks(){
        return taskList;
    }
    
    public Task getTask(int idTask){
        return taskList.get(idTask);
    }
    
    public Task updateTask(Task t){
        return taskList.set(t.getId(), t);
    }
    
    public Task deleteTask(int idTask){
        return taskList.remove(idTask);
    }
}
