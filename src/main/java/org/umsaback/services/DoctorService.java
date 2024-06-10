package org.umsaback.services;


import org.umsaback.models.dtos.DoctorDTO;
import org.umsaback.models.entities.Doctor;
import org.umsaback.repositories.DoctorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DoctorService {

	
	@Inject
	DoctorRepository doctorRepository;
	
	
	 public Doctor createDoctor(DoctorDTO doctorDTO) {
		 

		 	Doctor nuevoDoctor = new Doctor(doctorDTO.getEspecialidad());
		 	
		 	doctorRepository.persist(nuevoDoctor);
		
	        return doctorRepository.findByUUID(nuevoDoctor.getId());
	    }
	
}
