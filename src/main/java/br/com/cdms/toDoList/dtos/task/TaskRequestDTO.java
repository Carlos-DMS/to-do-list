package br.com.cdms.toDoList.dtos.task;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskRequestDTO(String title, String description, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate deadline) {
}
