package org.umsaback.resources;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
	
	
	@GET
	@Path("all")
	@Transactional
	public String getPaciente() {
		return "aca retornan los pacientes";
		//List<Paciente> pacientes = pacienteRepository.listAll();
		//return Response.ok(pacientes).build(); 
		
	}
	
	@GET
	@Path("/{cuit}")
	@Transactional
	public String getPacienteByCUIT(@PathParam("cuit") String cuit ) {
		
		//
		return "regresar paciente by ID";
	}
	

	@POST
	@Path("crear")
	@Transactional
    public Response createPaciente(PacienteDTO pacienteDTO) {
      
        Paciente createPaciente = pacienteService.createPaciente(pacienteDTO);
        return Response.status(Response.Status.CREATED).entity(createPaciente).build();
    }
	
	
	
	

}
