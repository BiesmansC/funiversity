package com.switchfully.api;

import com.switchfully.domain.dto.CreateProfessorDto;
import com.switchfully.domain.dto.ProfessorDto;
import com.switchfully.domain.dto.UpdateProfessorDto;
import com.switchfully.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;

@Path("/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(201) // CREATED
    public Response createProfessor(CreateProfessorDto createProfessorDto) {
        ProfessorDto professorDto = professorService.addProfessor(createProfessorDto);
        return Response.status(201).entity(professorDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200) // OK
    public ProfessorDto getProfessor(@PathParam("id") String id) {
        return professorService.getProfessor(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200) // OK
    public List<ProfessorDto> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(200) // OK
    public Response updateProfessor(UpdateProfessorDto updateProfessorDto, @PathParam("id") String id) {
        ProfessorDto professorDto = professorService.changeProfessor(updateProfessorDto, id);
        return Response.status(200).entity(professorDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(202) // ACCEPTED
    public Response deleteProfessor(@PathParam("id") String id) {
        professorService.removeProfessor(id);
        //return Response.accepted().build();
        return Response.status(202).build();
    }
}
