package org.umsaback.resources;


import org.umsaback.models.entities.Doctor;
import org.umsaback.services.DoctorService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/doctores")
@Transactional
public class DoctorResource {
	
	@Inject
	private DoctorService doctorService;
	
	@GET
	public Response mostratDoctores() {
		return doctorService.listarDoctores();
	}
	
	@POST
	public Response mostrarDoctor(Doctor nuevoDoctor) {
		return doctorService.crearDoctor(nuevoDoctor);
	}
	
	@GET
	@Path("nombre/{nombre}")
	public Response getByName(@PathParam("nombre") String nombre) {
		return doctorService.getByName(nombre);
	}
	

}
