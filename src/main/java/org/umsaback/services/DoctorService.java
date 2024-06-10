package org.umsaback.services;

import java.util.List;

import org.umsaback.enums.Especialidad;
import org.umsaback.models.entities.Doctor;
import org.umsaback.repositories.DoctorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class DoctorService {
	
	@Inject
	DoctorRepository doctorRepository;
	
	public Response listarDoctores(){
		return Response.ok(doctorRepository.listAll()).build();
	}
	
	public Response crearDoctor(Doctor nuevoDoctor) {
		doctorRepository.persist(nuevoDoctor);
		return Response.ok(nuevoDoctor).build();
	}
	
	public Response getByName(@PathParam("nombre") String nombre) {
		List<Doctor> doctores = doctorRepository.findByName(nombre);
		return Response.ok(doctores).build();
	}
	
	public Response getByEspecialidad(@PathParam("especialidad") Especialidad especialidad) {
		List<Doctor> doctores = doctorRepository.findByEspecialidad(especialidad);
		return Response.ok(doctores).build();
	}
	
	/*
	 * public Response deleteByDni(@PathParam("dni") String dni) { booleran
	 * eliminado = doctorRepository.delete(dni); return Response.ok(dni).build(); }
	 */
	
	
	
	

}
