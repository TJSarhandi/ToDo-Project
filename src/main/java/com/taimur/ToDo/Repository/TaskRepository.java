package com.taimur.ToDo.Repository;

import com.taimur.ToDo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);
}
