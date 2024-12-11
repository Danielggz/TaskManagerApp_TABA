 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.services;

import com.mycompany.taskmanagerapp.databases.Database;
import com.mycompany.taskmanagerapp.models.Project;
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
        return projList.get(idProj);
    }
    
    public Project updateProject(Project p){
        return projList.set(p.getId(), p);
    }
    
    public Project deleteProject(int idProj){
        return projList.remove(idProj);
    }
}
