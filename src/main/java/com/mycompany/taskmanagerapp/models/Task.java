/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.taskmanagerapp.models;

/**
 * @author Daniel García
 * 04/12/2024
 */
public class Task {
    private int id;
    private String name, description, status; //Status options are Pending, In Progress and Completed
    
    public Task(){
        
    }

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = "Pending"; //Status of task always start as pending
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

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task: \n" + "Id: " + id + "\nName: " + name + "\nDescription: " + description + "\nStatus: " + status;
    }
    
}
