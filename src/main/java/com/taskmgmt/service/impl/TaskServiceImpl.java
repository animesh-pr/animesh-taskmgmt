package com.taskmgmt.service.impl;

import com.taskmgmt.entity.Priority;
import com.taskmgmt.entity.Status;
import com.taskmgmt.entity.Task;
import com.taskmgmt.entity.User;
import com.taskmgmt.exception.ResourceNotFoundException;
import com.taskmgmt.repository.TaskRepository;
import com.taskmgmt.repository.UserRepository;
import com.taskmgmt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        if (task.getUser() != null && task.getUser().getId() != null) {
            User user = userRepository.findById(task.getUser().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + task.getUser().getId()));
            task.setUser(user);
        }
        return taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getTasksDueBefore(LocalDate dueDate) {
        return taskRepository.findByDueDateBefore(dueDate);
    }
}
