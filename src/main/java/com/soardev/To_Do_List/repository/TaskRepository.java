package com.soardev.To_Do_List.repository;

import com.soardev.To_Do_List.model.Task;
import com.soardev.To_Do_List.enums.TaskPriority;
import com.soardev.To_Do_List.enums.TaskStatus;
import com.soardev.To_Do_List.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByTaskPriority(TaskPriority taskPriority);

    List<Task> findByDueDateAfter(LocalDate date);

    List<Task> findByDueDateBefore(LocalDate date);

    List<Task> findByStatusAndTaskPriority(TaskStatus status, TaskPriority taskPriority);

    List<Task> findAllByUser(User user);

}
