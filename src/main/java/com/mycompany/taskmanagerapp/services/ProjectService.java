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
public class ProjectService {
    Database db = new Database();
    private List<Project> projList = db.getProjects();
    
    public Project createProject(Project newP){
        projList.add(newP);
        return newP;
    }
    
    public List<Project> getAllProjects(){
        return projList;
    }
    
    public Project getProject(int idProj){
        Project p = null;
        try{
            p = projList.get(idProj-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return p;
    }
    
    public Project updateProject(Project proj){
        Project p = null;
        try{
            //Check if project exists
            p = projList.get(proj.getId()-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return projList.set(proj.getId()-1, p);
    }
    
    public Project deleteProject(int idProj){
        Project p = null;
        try{
            //Check if project exists
            p = projList.get(idProj-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        return projList.remove(idProj-1);
    }
    
    public Project assignTasks(int projId, List<Task> taskList){
        Project p = null;
        try{
            //Check if project exists
            p = projList.get(projId-1);
        }catch(IndexOutOfBoundsException iob){
            System.out.println(iob.getMessage());
            return null;
        }
        //Assign list and return the project
        projList.get(projId).setListTasks(taskList);
        return projList.get(projId);
    }
    
    public List<Task> getAllTasksByStatus(String status){
        //Create list with tasks that have the status requested
        List<Task> tasksByStatus = new ArrayList<>();
        for(Project p: projList){
            if(p.getListTasks() != null){
                for(Task t: p.getListTasks()){
                    if(t.getStatus().equals(status))
                    tasksByStatus.add(t);
                }
            }
        }
        return tasksByStatus;
    }
}
