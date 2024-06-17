package org.umsaback.services;
import java.util.List;

import org.umsaback.exceptions.PatientNotFoundException;
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
	 
	 //NullPointerException para valores null ?
	 
	 public Paciente findByCuit(String cuit) throws PatientNotFoundException {
		 
		 	Paciente paciente = pacienteRepository.findByCuit(cuit);
		 
		    if (paciente == null) {
		    	
		        throw new PatientNotFoundException("Patient with CUIT " + cuit + " not found");
		    }
			return paciente;
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
	 
	
	 
	 public Paciente deletePacienteByCuit(String cuit) throws PatientNotFoundException{
		 
		 Paciente deletedPatient = pacienteRepository.findByCuit(cuit);
		 
		 if(deletedPatient == null) {
			 throw new PatientNotFoundException("Patient with CUIT " + cuit + " not found");
		 }
		 
		 pacienteRepository.delete(deletedPatient);
		 
		 return deletedPatient;
	 }
	 
	 
	 public Paciente updatePatient(String cuit, PacienteDTO pacienteDTO ) throws PatientNotFoundException{
		 
		 Paciente updatedPatient = pacienteRepository.findByCuit(cuit);
		 
		 if(updatedPatient == null) {
			 throw new PatientNotFoundException("Patient with CUIT " + cuit + " not found");
		 }
		 
		 // Para el caso de un solo campo ?
	     //pacienteRepository.getEntityManager().merge(pacienteDTO);
		 // Debe haber otro metodo para hacer un merge
		 
		 updatedPatient.setNombre(pacienteDTO.getNombre());
		 updatedPatient.setApellido(pacienteDTO.getApellido());
		 updatedPatient.setDni(pacienteDTO.getDni());
		 updatedPatient.setDomicilio(pacienteDTO.getDomicilio());
		 updatedPatient.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
		 updatedPatient.setCelular(pacienteDTO.getCelular());
		 updatedPatient.setObraSocial(pacienteDTO.getObraSocial());
		
		 pacienteRepository.persist(updatedPatient);
		 
		 return updatedPatient;
	 }
	 
		
}
