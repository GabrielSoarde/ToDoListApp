package com.soardev.To_Do_List.DTO;

import com.soardev.To_Do_List.enums.TaskPriority;
import com.soardev.To_Do_List.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public class TaskDTO {

    @NotBlank(message = "O título é obrigatório")
    private String title;

    private String description;
    @NotNull(message = "A data de vencimento é obrigatória")
    @FutureOrPresent(message = "A data deve ser a de hoje ou no futuro")
    private LocalDate dueDate;

    @NotNull (message = "O status é obrigatório")
    private TaskStatus status;

    @NotNull(message = "A prioridade é obrigatória")
    private TaskPriority taskPriority;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return taskPriority;
    }

    public void setPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }
}
