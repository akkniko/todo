package org.example.introspr.service;
import org.example.introspr.model.Task;
import org.example.introspr.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    
    private final TaskRepository repository;

    public TaskService(TaskRepository rp){
        this.repository = rp;
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task getTaskById(Long id){
        return repository.findById(id).
                orElseThrow(() -> new RuntimeException("tasks with id " + id +" not found"));
    }

//    public Task getTaskByCreatedTime(LocalDateTime time){
//        return repository.findByCreatedAt(time);
//    }
}
