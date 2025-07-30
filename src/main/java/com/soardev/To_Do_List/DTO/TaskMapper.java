package com.soardev.To_Do_List.DTO;


import com.soardev.To_Do_List.model.Task;
import com.soardev.To_Do_List.model.User;

public class TaskMapper {

    public static Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());

        return task;
    }

    public static TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getStatus(),
            task.getPriority(),
            task.getUser().getId()
        );
    }
}
