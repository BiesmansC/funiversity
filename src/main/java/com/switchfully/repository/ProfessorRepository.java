package com.switchfully.repository;

import com.switchfully.domain.Professor;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class ProfessorRepository {
    private final Map<String, Professor> professorById;

    public ProfessorRepository() {
        Professor jonesy = new Professor("Jonesy", "The Torti");
        Professor flint = new Professor("Flint", "The Black Cat");
        this.professorById = new ConcurrentHashMap<>(Map.of(
                jonesy.getId(), jonesy,
                flint.getId(), flint
        ));
    }

    public Professor save(Professor professor) {
        professorById.put(professor.getId(), professor);
        return professor;
    }

    public Optional<Professor> getById(String id) {
        Professor foundProfessor = professorById.get(id);
        return Optional.ofNullable(foundProfessor);
    }

    public Collection<Professor> getAll() {
        return professorById.values();
    }

    public boolean delete(String id) {
        Professor professor = professorById.remove(id);
        return professor != null;
    }
}
