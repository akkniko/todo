package org.example.introspr.repository;

import org.example.introspr.dto.createTaskRequest;
import org.example.introspr.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


//datajpa реализует эти методы по названию
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
    List<Task> findByTitle(String key);
    void deleteByCompleted(boolean completed);
    Task findByCreatedAt(LocalDateTime time);
}
