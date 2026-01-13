package com.taskmgmt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.taskmgmt.entity.Task;

public interface TaskService {

    Task saveTask(Task task);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

    void deleteTask(Long id);

    List<Task> getTasksByStatus(String status);

    List<Task> getTasksByPriority(String priority);

    List<Task> getTasksByDueDateBefore(LocalDate date);
}
