package org.umsaback.resources;


import org.umsaback.models.dtos.DoctorDTO;
import org.umsaback.models.entities.Doctor;

import java.util.List;

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
	
	@GET
	@Path("/list")
	public Response listDoctors() {
		List<Doctor> doctors = doctorService.listDoctors();
		if(doctors.isEmpty()) {
			return Response.status(404).entity("No hay doctores").build();
		} else {
			return Response.ok(doctors).build();			
		}
	}
	
	@POST
	@Path("create")
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
	
	/*
	 * @GET
	 * 
	 * @Path("{nombre}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Doctor>
	 * getDoctorbyNombre(@PathParam("nombre") String nombre) { return
	 * repository.buscarPorNombre(nombre); } public Response mostrarDoctor(Doctor
	 * nuevoDoctor) { return doctorService.crearDoctor(nuevoDoctor); }
	 */
	
	@GET
	@Path("name/{name}")
	public Response getByName(@PathParam("name") String name) {
		return doctorService.getByName(name);
	}
	
	@GET
	@Path("specialty/{specialty}")
	public Response getByEspecialidad(@PathParam("specialty") Especialidad specialty) {
		return doctorService.getByEspecialidad(specialty);
	}
	
//	@DELETE
//	@Path("{dni}")
//	public Response deleteDoctor(@PathParam("dni") String dni) {
//		return doctorService.
//	}
	

}
