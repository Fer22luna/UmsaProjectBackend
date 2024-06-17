package org.umsaback.resources;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.umsaback.exceptions.PatientNotFoundException;
import org.umsaback.models.dtos.PacienteDTO;
import org.umsaback.models.entities.Paciente;
import org.umsaback.services.PacienteService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@Path("/paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource {
	
		
	@Inject
	PacienteService pacienteService;
	
	
	
	@GET
	@Path("all")
	@Operation(operationId = "getAllPaciente",
			summary = "get all patients")
	@APIResponses({
	@APIResponse(
			responseCode = "200",
			description = "Patient getting All",
			content = @Content(
				mediaType = MediaType.APPLICATION_JSON,
			    schema = @Schema(implementation = Paciente.class))
			),
//	@APIResponse(
//			responseCode = "404",
//			description = "not found",
//			content = @Content(mediaType = MediaType.APPLICATION_JSON)
//			)
	}
	)
	@Transactional
	public Response getAllPaciente() {
		
		List<Paciente> listaPacientes= pacienteService.listAll();
		return Response.status(Response.Status.OK).entity(listaPacientes).build();
	}		
	
	@GET
	@Path("{cuit}")
	@Operation(operationId = "getPacienteByCUIT",
	summary = "Get Patient by cuit")
	@APIResponses({
		@APIResponse(
				responseCode = "200",
				description = "Find and get an Patient by CUIT ",
				content = @Content(
						mediaType = MediaType.APPLICATION_JSON,
						schema = @Schema(implementation = Paciente.class))
	)})
	@Transactional
	public Response getPacienteByCUIT(
			@Parameter(description="Patient's cuit", required=true) 
			@PathParam("cuit") String cuit ) {
		
		try {
	     Paciente  paciente = pacienteService.findByCuit(cuit);
			
			return  Response.status(Response.Status.OK).entity(paciente).build();
			
		} catch (PatientNotFoundException e) {
			
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();

		} catch (Exception e) {
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}
	
	@POST
	@Path("crear")
	@Operation(operationId = "createPaciente",
	summary = "create a new Patient")
		@APIResponses({
			@APIResponse(
					responseCode = "201",
					description = "create a new Patient",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Paciente.class))
	)})
	@Transactional
    public Response createPaciente(PacienteDTO pacienteDTO) {
      
        Paciente createPaciente = pacienteService.createPaciente(pacienteDTO);
        		
        return Response.status(Response.Status.CREATED).entity(createPaciente).build();
    }
	
	@PUT
	@Path("{cuit}")
	@Transactional
	@Operation(operationId = "updatePaciente",
	summary = "update a Patient by CUIT")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "update a Patient",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Paciente.class))
	)})
	public Response updatePaciente(
			@Parameter(description= "Patient cuit",required=true)
			@PathParam("cuit") String cuit, PacienteDTO pacienteDTO) {
		
		
		try {
			
		Paciente updatedPaciente = pacienteService.updatePatient(cuit, pacienteDTO);
			return Response.status(Response.Status.OK).entity(updatedPaciente).build();
			
		} catch (PatientNotFoundException e) {
			
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();

		} catch (Exception e) {
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}	
		
	}

	@DELETE
	@Path("{cuit}")
	@Operation(operationId = "deletePaciente",
	summary = "delete a Patient by CUIT")
		@APIResponses({
			@APIResponse(
					responseCode = "200",
					description = "delete a Patient",
					content = @Content(
							mediaType = MediaType.APPLICATION_JSON,
							schema = @Schema(implementation = Paciente.class))
	)})
	@Transactional
	public Response deletePaciente (
			@Parameter(description="cuit", required=true) 
			@PathParam("cuit") String cuit) {
	
		try {
		Paciente deletedPaciente = pacienteService.deletePacienteByCuit(cuit);
		return Response.status(Response.Status.OK).entity(deletedPaciente).build();
		} catch (PatientNotFoundException e) {
			
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();

		} catch (Exception e) {
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}
