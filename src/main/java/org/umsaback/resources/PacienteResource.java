package org.umsaback.resources;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.umsaback.models.dtos.PacienteDTO;
import org.umsaback.models.entities.Paciente;
import org.umsaback.services.PacienteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@Path("/paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource {
	
		
	@Inject
	PacienteService pacienteService;
	
	// Traer a todos los Pacientes
	@GET
	@Path("todos")
	@Transactional
	public Response getAllPaciente() {
		
		List<Paciente> listaPacientes= pacienteService.listAll();
		return Response.status(Response.Status.OK).entity(listaPacientes).build();
	}		
	
	// Traer pacientes por CUIT
	@GET
	@Path("/{cuit}")
	@Transactional
	public Response getPacienteByCUIT(@PathParam("cuit") String cuit ) {
		
		Paciente paciente = pacienteService.findByCuit(cuit);
		return Response.status(Response.Status.OK).entity(paciente).build();
		
	}
	
	// crear paciente
	@POST
	@Path("crear")
	@Transactional
    public Response createPaciente(PacienteDTO pacienteDTO) {
      
        Paciente createPaciente = pacienteService.createPaciente(pacienteDTO);
        return Response.status(Response.Status.CREATED).entity(createPaciente).build();
    }
	
	
//	@Update
//	@Path("actualizar/{cuit}")
//	@Transactional
//	public Response updatePaciente(PacienteDTO pacienteDTO) {
//		
//	}

	
	
	
	
	

}
