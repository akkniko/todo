package org.example.introspr.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;


//по сути просто таблица

@Entity
@Table(name = "tasks")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;
    private final LocalDateTime createdAt = LocalDateTime.now();

    public Task(){};

    public Task(String title){
        this.title = title;
        this.completed = false;
    }

    public Long getId() { return id; }
    public String getTitle(){ return title; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public LocalDateTime getCreatedAt(){ return this.createdAt;}
}