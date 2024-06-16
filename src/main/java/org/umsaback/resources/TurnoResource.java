package org.umsaback.resources;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.umsaback.models.dtos.TurnoDTO;
import org.umsaback.models.entities.Turno;
import org.umsaback.services.TurnoService;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/turno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TurnoResource {

	@Inject
	TurnoService turnoService;
	

	@GET
	@Path("all")
	@Operation(operationId = "getAllTurnos",
	summary = "get All appointments")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "Get All appointments ",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Turno.class))
	)})
	@Transactional
	public Response getAllTurnos() {
		
		List<Turno> listaTurno= turnoService.listAll();
		return Response.status(Response.Status.OK).entity(listaTurno).build();
	}		
	
	@GET
	@Path("{id}")
	@Operation(operationId = "getTurnoById",
	summary = "Get All Appointments")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "Get Appointment by Id ",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Turno.class))
	)})
	@Transactional
	public Response getTurnoById(
			@Parameter(description="Appointment Id", required=true) 
			@PathParam("id") String id ) {
		
		Turno turno = turnoService.findById(id);
		return Response.status(Response.Status.OK).entity(turno).build();
		
	}
	
	@POST
	@Path("nuevoTurno")
	@Operation(operationId = "createTurno",
	summary = "Create an appointment")
		@APIResponses({
			@APIResponse(
					responseCode = "201",
					description = "Create anAppointment",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Turno.class))
	)})
	@Transactional
    public Response createTurno(TurnoDTO turnoDTO) {
      
        Turno createTurno = turnoService.createTurno(turnoDTO);
        return Response.status(Response.Status.CREATED).entity(createTurno).build();
    }
	
	@PUT
	@Path("{id}")
	@Operation(operationId = "updateTurno",
	summary = "Update appointment by Id")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "update appointment by Id ",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Turno.class))
	)})
	@Transactional
	public Response updateTurno(
			@Parameter(description="Appointment Id", required=true) 
			@PathParam("id") String id, TurnoDTO turnoDTO) {
		
		Turno updatedTurno = turnoService.updateTurno(id, turnoDTO);	
		return Response.status(Response.Status.OK).entity(updatedTurno).build();	
	}

	@DELETE
	@Path("{id}")
	@Operation(operationId = "deleteTurnos",
	summary = "Delete appointment by Id")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "Delete appointment by Id ",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Turno.class))
	)})
	@Transactional
	public Response deleteTurno (
			@Parameter(description="Appointment Id", required=true) 
			@PathParam("id") String id) {
		
		Turno deletedTurno = turnoService.deleteTurnoById(id);
		return Response.status(Response.Status.OK).entity(deletedTurno).build();
	}
}
