package org.example.introspr.controller;

import org.example.introspr.dto.createTaskRequest;
import org.example.introspr.model.Task;
import org.example.introspr.repository.TaskRepository;
import org.example.introspr.service.TaskService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody createTaskRequest dto){
        Task newTask = service.createTask(dto);
        return ResponseEntity.status(201).body(newTask);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody @NonNull createTaskRequest dto, @RequestParam Long id){
        Task t = service.getTaskById(id);

        if(dto.getTitle()!=null) {
            t.setTitle(dto.getTitle());
        }
        
        t.setCompleted(false);
//        TaskRepository.save(id);

        return t;

    }




}
