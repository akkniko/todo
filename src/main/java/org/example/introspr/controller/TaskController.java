package org.example.introspr.controller;

import org.example.introspr.dto.createTaskRequest;
import org.example.introspr.model.Task;
import org.example.introspr.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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




//    @PutMapping()
//    public String updateTask(@PathVariable Task task, @PathParam() ){
//
//    }

}
