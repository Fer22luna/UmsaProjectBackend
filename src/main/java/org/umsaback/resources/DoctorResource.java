package org.umsaback.resources;

import java.util.List;

import org.umsaback.models.entities.Doctor;
import org.umsaback.repositories.DoctorRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.experimental.var;

@Path("/doctores")
@Transactional
public class DoctorResource {
	
	@Inject
	private DoctorRepository repository;
	
	@GET
	public List<Doctor> index() {	// Muestro todos los Doctores
		return repository.listAll();
	}
	
	@POST
	public Doctor insert(Doctor insertedDoctor) {
		repository.persist(insertedDoctor);
		return insertedDoctor;
	}
	
	@GET
	@Path("{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDoctorbyNombre(@PathParam("nombre") String nombre) {
		return repository.buscarPorNombre(nombre);
	}
	

}
