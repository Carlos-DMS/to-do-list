package br.com.cdms.toDoList.repositories;

import br.com.cdms.toDoList.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
