package com.switchfully.domain.dto;

public class CreateProfessorDto {
    private String firstName;
    private String lastName;

    public CreateProfessorDto() {
    }

    public CreateProfessorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
