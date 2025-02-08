package br.com.cdms.toDoList.services;

import br.com.cdms.toDoList.dtos.task.StatusUpdateDTO;
import br.com.cdms.toDoList.dtos.task.TaskRequestDTO;
import br.com.cdms.toDoList.dtos.task.TaskResponseDTO;
import br.com.cdms.toDoList.models.TaskModel;
import br.com.cdms.toDoList.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Transactional
    public void registerTask(TaskRequestDTO body) {
        repository.save(new TaskModel(body.title(), body.description(), body.deadline()));
    }

    public List<TaskResponseDTO> getAllTasks() {
        return repository.findAll().stream().map(task -> new TaskResponseDTO(task.getId(), task.getTitle(), task.getDescription(), task.getDeadline(), task.getStatus())).toList();
    }

    @Transactional
    public void updateTask(Long id, TaskRequestDTO body) {
        Optional<TaskModel> task = repository.findById(id);

        if (task.isPresent()) {
            task.get().setTitle(body.title());
            task.get().setDescription(body.description());
            task.get().setDeadline(body.deadline());

            repository.save(task.get());
        }
    }

    @Transactional
    public void updateTaskStatus(Long id, StatusUpdateDTO body) {
        Optional<TaskModel> task = repository.findById(id);

        if (task.isPresent()) {
            task.get().setStatus(!body.status());
            repository.save(task.get());
        }
    }

    @Transactional
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
