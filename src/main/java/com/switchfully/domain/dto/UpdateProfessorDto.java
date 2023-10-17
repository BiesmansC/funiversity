package com.switchfully.domain.dto;

public class UpdateProfessorDto {
    private String firstName;
    private String lastName;

    public UpdateProfessorDto() {
    }

    public UpdateProfessorDto(String firstName, String lastName) {
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
