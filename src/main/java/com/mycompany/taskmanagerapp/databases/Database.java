/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.databases;

import com.mycompany.taskmanagerapp.models.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel García
 * 11/12/2024
 */
public class Database {
    public static List<Project> projects = new ArrayList<>();
    public static List<Task> tasks = new ArrayList<>();
    
    public Database(){
        
    }

    public static List<Project> getProjects() {
        return projects;
    }

    public static List<Task> getTasks() {
        return tasks;
    }
}
