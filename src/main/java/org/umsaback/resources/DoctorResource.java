package org.umsaback.resources;


import org.umsaback.models.dtos.DoctorDTO;
import org.umsaback.models.entities.Doctor;

import org.umsaback.enums.Especialidad;
import org.umsaback.models.entities.Doctor;
import org.umsaback.services.DoctorService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import jakarta.ws.rs.core.Response;

@Path("/doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
	
	@Inject
  DoctorService doctorService;
//	
//	@GET
//	public List<Doctor> index() {	// Muestro todos los Doctores
//		return repository.listAll();
//	}
	
//	@POST
//	public Doctor insert(DoctorDTO doctorDTO) {
//		repository.persist(insertedDoctor);
//		return insertedDoctor;
//	}

	

	@POST
	@Path("crear")
	@Transactional
    public Response createDoctor(DoctorDTO doctorDTO) {
      
	try {
        Doctor createDoctor = doctorService.createDoctor(doctorDTO);
        return Response.status(Response.Status.CREATED).entity(createDoctor).build();
	} catch (IllegalArgumentException e) {
        e.printStackTrace();
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity("Especialidad no válida: " + doctorDTO.getEspecialidad())
                       .build();
    } catch (Exception e) {
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity("Error inesperado al crear el doctor")
                       .build();
    }
    }
	
//	@GET
//	@Path("{nombre}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Doctor> getDoctorbyNombre(@PathParam("nombre") String nombre) {
//		return repository.buscarPorNombre(nombre);
//	}
  
//	public Response mostrarDoctor(Doctor nuevoDoctor) {
//		return doctorService.crearDoctor(nuevoDoctor);
//	}
	
	@GET
	@Path("nombre/{nombre}")
	public Response getByName(@PathParam("nombre") String nombre) {
		return doctorService.getByName(nombre);
	}

	
	@GET
	@Path("especialidad/{especialidad}")
	public Response getByEspecialidad(@PathParam("especialidad") Especialidad especialidad) {
		return doctorService.getByEspecialidad(especialidad);
	}
	
//	@DELETE
//	@Path("{dni}")
//	public Response deleteDoctor(@PathParam("dni") String dni) {
//		return doctorService.
//	}
	

}
