package br.com.cdms.toDoList.dtos.task;

public record TaskResponseDTO(Long id, String name, String description, String deadline, Boolean status) {
}
