package com.taimur.ToDo.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String title);

    List<Task> findAllByUsername(String title);
}
