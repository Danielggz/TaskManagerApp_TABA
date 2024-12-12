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
    public static boolean init = true;
    
    public Database(){
        if(init) {
            Project p1 = new Project(1, "Advanced Programming", "Create a web application with Java");
            Project p2 = new Project(2, "Introduction to AI", "Project with Machine Learning");
            Project p3 = new Project(3, "Advanced Networks", "Packet tracer network simulated");
            //Create comments for message 3
            ArrayList<Task> p1Tasks = new ArrayList<>();
            p1Tasks.add(new Task(1, "Create project", "Create the project with Java Maven. Add structure files(models, database, resources and services)"));
            p1Tasks.add(new Task(2, "Add functionality", "Add functionality to the files"));
            p1Tasks.add(new Task(3, "Test", "Test the functionality with postman"));
            p1.setListTasks(p1Tasks);
            ArrayList<Task> p2Tasks = new ArrayList<>();
            p2Tasks.add(new Task(1, "Datasets", "Find online datasets suitable for Linear Regression"));
            p2Tasks.add(new Task(2, "Create file", "Create python file and add functions and plots"));
            p2.setListTasks(p2Tasks);

            projects.add(p1);
            projects.add(p2);
            projects.add(p3);
            init = false;
        } 
    }

    public static List<Project> getProjects() {
        return projects;
    }

    public static List<Task> getTasks() {
        return tasks;
    }
}
