package com.taskmgmt.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmgmt.entity.Priority;
import com.taskmgmt.entity.Status;
import com.taskmgmt.entity.Task;
import com.taskmgmt.repository.TaskRepository;
import com.taskmgmt.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        try {
            Status taskStatus = Status.valueOf(status.toUpperCase());
            return taskRepository.findByStatus(taskStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status value. Use PENDING or COMPLETED");
        }
    }

    @Override
    public List<Task> getTasksByPriority(String priority) {
        try {
            Priority taskPriority = Priority.valueOf(priority.toUpperCase());
            return taskRepository.findByPriority(taskPriority);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid priority value. Use HIGH, MEDIUM, or LOW");
        }
    }

    @Override
    public List<Task> getTasksByDueDateBefore(LocalDate date) {
        return taskRepository.findByDueDateBefore(date);
    }
}
