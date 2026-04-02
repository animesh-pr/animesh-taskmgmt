package com.taskmgmt.repository;

import com.taskmgmt.entity.Priority;
import com.taskmgmt.entity.Status;
import com.taskmgmt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
    List<Task> findByPriority(Priority priority);
    List<Task> findByDueDateBefore(LocalDate dueDate);
}
