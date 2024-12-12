/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.models;

import java.util.List;

/**
 * @author Daniel García
 * 04/12/2024
 */
public class Project {
    private int id;
    private String name, description;
    private List<Task> listTasks;
    
    public Project(){
        
    }

    public Project(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListTasks(List<Task> listTasks) {
        this.listTasks = listTasks;
    }
    
    public void addTask(Task newT){
        this.listTasks.add(newT);
    }

    @Override
    public String toString() {
        return "Project: \n" + "Id: " + id + "\nName: " + name + "\nDescription: " + description;
    }
    
}
