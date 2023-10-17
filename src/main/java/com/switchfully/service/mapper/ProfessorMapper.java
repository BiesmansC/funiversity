package com.switchfully.service.mapper;

import com.switchfully.domain.Professor;
import com.switchfully.domain.dto.CreateProfessorDto;
import com.switchfully.domain.dto.ProfessorDto;
import com.switchfully.domain.dto.UpdateProfessorDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProfessorMapper {
    // todo some mappers need to be removed
    public ProfessorDto mapToDto(Professor professor) {
        return new ProfessorDto(professor.getId(), professor.getFirstName(), professor.getLastName());
    }

    public List<ProfessorDto> mapToDto(List<Professor> professors) {
        return professors
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Professor mapToEntity(ProfessorDto professorDto) {
        return new Professor(professorDto.getFirstName(), professorDto.getLastName());
    }

    public CreateProfessorDto mapToCreateDto(Professor professor) {
        return new CreateProfessorDto(professor.getFirstName(), professor.getLastName());
    }

    public Professor mapToEntity(CreateProfessorDto createProfessorDto) {
        return new Professor(createProfessorDto.getFirstName(), createProfessorDto.getLastName());
    }

    public UpdateProfessorDto mapToUpdateDto(Professor professor) {
        return new UpdateProfessorDto(professor.getFirstName(), professor.getLastName());
    }

    public Professor mapToEntity(UpdateProfessorDto updateProfessorDto) {
        return new Professor(updateProfessorDto.getFirstName(), updateProfessorDto.getLastName());
    }
}
