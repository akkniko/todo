package org.example.introspr.dto;

public class createTaskRequest {

    private String title;
    createTaskRequest(){};

    createTaskRequest(String title){
        this.title = title;
    }

    public String getTitle(){return this.title;}
    public void setTitle(String title) { this.title = title;}

}
