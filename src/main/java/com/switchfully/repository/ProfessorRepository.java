package com.switchfully.repository;

import com.switchfully.domain.Professor;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.Map;
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

    public Professor getById(String id) {
        Professor foundProfessor = professorById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("No Professor could be found for id " + id);
        }
        return foundProfessor;
    }

    public Collection<Professor> getAll() {
        return professorById.values();
    }

    public boolean delete(String id){
        Professor professor = professorById.remove(id);
        return professor != null;
    }
}
