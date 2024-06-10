package org.umsaback.services;
import java.util.List;

import org.umsaback.models.dtos.PacienteDTO;
import org.umsaback.models.entities.Paciente;
import org.umsaback.repositories.PacienteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class PacienteService {

	 @Inject 
	 PacienteRepository pacienteRepository;
	 
	 
	 public List<Paciente> listAll(){
			return pacienteRepository.listAll();
		}
	 
	 public Paciente findByCuit(String cuit){
		 
			return pacienteRepository.findByCuit(cuit);
		}	 
	 
	 
	 public Paciente createPaciente(PacienteDTO pacienteDTO) {

		 	Paciente nuevoPaciente = new Paciente(
		 			pacienteDTO.getNombre(), pacienteDTO.getApellido(), pacienteDTO.getDni(),
		 			pacienteDTO.getDomicilio(),pacienteDTO.getFechaNacimiento(),pacienteDTO.getCelular(),
		 			pacienteDTO.getObraSocial(),pacienteDTO.getCuit()
		 			);
		
		 	pacienteRepository.persist(nuevoPaciente);
		
	        return pacienteRepository.findById(nuevoPaciente.getId());
	    }
	 
	 
	 
		
}
