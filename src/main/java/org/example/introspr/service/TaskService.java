package org.example.introspr.service;
import jakarta.annotation.Nonnull;
import org.apache.coyote.BadRequestException;
import org.example.introspr.dto.createTaskRequest;
import org.example.introspr.dto.updateTaskRequest;
import org.example.introspr.model.Task;
import org.example.introspr.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id " + id + " not found")
                );
    }

    public Task createTask(createTaskRequest task){
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setCompleted(false);

        return repository.save(newTask);
    }
    public Task updateTask(updateTaskRequest task, Long id){
      if(task.title() == null || task.title().isBlank()){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "task's title must be non-empty");
      }

      Task t = getTaskById(id);
      t.setTitle(task.title());
      t.setCompleted(task.completed());
      return repository.save(t);
    }
}
