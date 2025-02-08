package br.com.cdms.toDoList.controllers;

import br.com.cdms.toDoList.dtos.task.StatusUpdateDTO;
import br.com.cdms.toDoList.dtos.task.TaskRequestDTO;
import br.com.cdms.toDoList.dtos.task.TaskResponseDTO;
import br.com.cdms.toDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class taskController {
    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<String> registerTask(@RequestBody TaskRequestDTO body) {
        service.registerTask(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.status((HttpStatus.OK)).body(service.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO body) {
        service.updateTask(id, body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO body) {
        service.updateTaskStatus(id, body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
