package com.switchfully.domain.dto;

public class ProfessorDto {
    private String id;
    private String firstName;
    private String lastName;

    public ProfessorDto() {
    }

    public ProfessorDto(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
