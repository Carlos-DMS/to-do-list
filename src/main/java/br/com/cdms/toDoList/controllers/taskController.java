package br.com.cdms.toDoList.controllers;

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

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.status((HttpStatus.OK)).build(/*colocar aqui retorno do service*/);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@RequestBody TaskRequestDTO body) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(@RequestParam Boolean status) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
