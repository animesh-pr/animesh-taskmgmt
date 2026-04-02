package com.taskmgmt.service;

import com.taskmgmt.entity.Priority;
import com.taskmgmt.entity.Status;
import com.taskmgmt.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    void deleteTask(Long id);
    List<Task> getTasksByStatus(Status status);
    List<Task> getTasksByPriority(Priority priority);
    List<Task> getTasksDueBefore(LocalDate dueDate);
}
