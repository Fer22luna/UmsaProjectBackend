package org.umsaback.services;



import org.umsaback.models.dtos.DoctorDTO;

import java.util.ArrayList;
import java.util.List;

import org.umsaback.enums.Especialidad;

import org.umsaback.models.entities.Doctor;
import org.umsaback.repositories.DoctorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;


@ApplicationScoped
public class DoctorService {
	
	@Inject
	DoctorRepository doctorRepository;
	
	public boolean isEmpty() {
		return (doctorRepository.listAll()).isEmpty();
	}
	
	public List<Doctor> listDoctors(){
		return doctorRepository.listAll();
	}
	
	public Response createDoctor(Doctor newDoctor) {
		doctorRepository.persist(newDoctor);
		return Response.ok(newDoctor).build();
	}
	
	public Response getByName(@PathParam("name") String name) {
		List<Doctor> doctors = doctorRepository.findByName(name);
		return Response.ok(doctors).build();
	}
	
	public Response getByEspecialidad(@PathParam("especialidad") Especialidad especialidad) {
		List<Doctor> doctors = doctorRepository.findByEspecialidad(especialidad);
		return Response.ok(doctors).build();
	}
	
	 public Doctor createDoctor(DoctorDTO doctorDTO) {
		 	Doctor newDoctor = new Doctor(doctorDTO.getEspecialidad());
		 	doctorRepository.persist(newDoctor);
	        return doctorRepository.findByUUID(newDoctor.getId());
	    }
	 
//	 @DELETE
//	 public Response deleteByDni(@PathParam("dni") String dni) { 
//		 boolean eliminado = doctorRepository.delete(dni); 
//		 return Response.ok(dni).build(); }
		 
	
}
