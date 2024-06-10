package org.umsaback.resources;

import org.umsaback.models.dtos.TurnoDTO;
import org.umsaback.models.entities.Turno;
import org.umsaback.services.TurnoService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/turno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TurnoResource {

	@Inject
	TurnoService turnoService;
	
	

	
	@POST
	@Path("nuevo")
	@Transactional
    public Response createTurno(TurnoDTO turnoDTO) {
      
        Turno createTurno = turnoService.createTurno(turnoDTO);
        return Response.status(Response.Status.CREATED).entity(createTurno).build();
    }
	
	
	
}
