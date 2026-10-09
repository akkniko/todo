package org.example.introspr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createTaskRequest {

    private String title;
    private boolean completed;
    createTaskRequest(){};

    createTaskRequest(String title){
        this.title = title;
    }

    public String getTitle(){return this.title;}
    public void setTitle(String title) { this.title = title;}

}
