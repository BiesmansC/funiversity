package com.switchfully.service;

import com.switchfully.domain.Professor;
import com.switchfully.domain.dto.CreateProfessorDto;
import com.switchfully.domain.dto.ProfessorDto;
import com.switchfully.domain.dto.UpdateProfessorDto;
import com.switchfully.repository.ProfessorRepository;
import com.switchfully.service.mapper.ProfessorMapper;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorDto addProfessor(CreateProfessorDto createProfessorDto) {
        Professor savedProfessor = professorRepository.save(professorMapper.mapToEntity(createProfessorDto));
        return professorMapper.mapToDto(savedProfessor);
    }

    public ProfessorDto getProfessor(String id) {
        return professorMapper.mapToDto(
                professorRepository
                        .getById(id)
                        .orElseThrow(() -> new IllegalArgumentException("No Professor could be found for id " + id)));
    }

    public List<ProfessorDto> getAllProfessors() {
        return professorMapper.mapToDto(
                professorRepository.getAll()
                        .stream()
                        .toList());
    }

    public ProfessorDto changeProfessor(UpdateProfessorDto updateProfessorDto, String id) {
        Professor professor = professorRepository
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Professor could be found for id " + id));
        professor.setFirstName(updateProfessorDto.getFirstName());
        professor.setLastName(updateProfessorDto.getLastName());
        return professorMapper.mapToDto(professor);
    }

    public boolean removeProfessor(String id) {
        return professorRepository.delete(id);
    }
}
