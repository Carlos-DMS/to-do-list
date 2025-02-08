package br.com.cdms.toDoList.dtos.task;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskResponseDTO(Long id, String name, String description, @JsonFormat(pattern = "yyyy-MM-dd") LocalDate deadline, Boolean status) {
}
