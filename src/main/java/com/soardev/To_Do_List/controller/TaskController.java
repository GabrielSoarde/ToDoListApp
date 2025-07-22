package com.soardev.To_Do_List.controller;

import com.soardev.To_Do_List.DTO.TaskDTO;
import com.soardev.To_Do_List.DTO.TaskMapper;
import com.soardev.To_Do_List.DTO.TaskResponseDTO;
import com.soardev.To_Do_List.model.Task;
import com.soardev.To_Do_List.model.User;
import com.soardev.To_Do_List.repository.TaskRepository;
import com.soardev.To_Do_List.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return taskRepository.findAllByUser(user).stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Task> taskOpt = taskRepository.findById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            if (task.getUser().getEmail().equals(userDetails.getUsername())) {
                return ResponseEntity.ok(TaskMapper.toDTO(task));
            }
        }
        return ResponseEntity.status(403).build();
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Task task = TaskMapper.toEntity(dto);
        task.setUser(user);
        Task saved = taskRepository.save(task);
        return ResponseEntity.ok(TaskMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Task> taskOpt = taskRepository.findById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            if (!task.getUser().getEmail().equals(userDetails.getUsername())) {
                return ResponseEntity.status(403).build();
            }

            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setDueDate(dto.getDueDate());
            task.setStatus(dto.getStatus());
            task.setPriority(dto.getPriority());

            Task updated = taskRepository.save(task);
            return ResponseEntity.ok(TaskMapper.toDTO(updated));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Task> taskOpt = taskRepository.findById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            if (!task.getUser().getEmail().equals(userDetails.getUsername())) {
                return ResponseEntity.status(403).build();
            }
            taskRepository.delete(task);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
