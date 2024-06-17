package org.umsaback.services;

import java.util.List;

import org.umsaback.exceptions.TurnoNotFoundException;
import org.umsaback.models.dtos.TurnoDTO;
import org.umsaback.models.entities.Doctor;
import org.umsaback.models.entities.Paciente;
import org.umsaback.models.entities.Turno;
import org.umsaback.repositories.DoctorRepository;
import org.umsaback.repositories.PacienteRepository;
import org.umsaback.repositories.TurnoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TurnoService {

	
	@Inject
	TurnoRepository turnoRepository;
	
	@Inject
	PacienteRepository pacienteRepository;
	
	@Inject
	DoctorRepository doctorRepository;
	
	
	 public List<Turno> listAll(){
			return turnoRepository.listAll();
		}
	 
	 public Turno findById(String id) throws TurnoNotFoundException{
		 
		 	Turno turno = turnoRepository.findByUUID(id);
		 	
		 	if(turno == null) {
		 		
		 		throw new TurnoNotFoundException("Turno with id " + id + "not found ");
		 	}
			return turno;
		}	 
	 
	
	 public Turno createTurno(TurnoDTO turnoDTO) {

		 	Doctor doctorTurno = doctorRepository.findByUUID(turnoDTO.getDoctorId());
		 	
		 	Paciente pacienteTurno = pacienteRepository.findByUUID(turnoDTO.getPacienteId());
		 
		 	Turno nuevoTurno = new Turno(turnoDTO.getFechaHoraTurno(), doctorTurno, turnoDTO.getDomicilioConsulta(), turnoDTO.getEstadoTurno(), pacienteTurno);
		 	
		 	turnoRepository.persist(nuevoTurno);
		
	        return turnoRepository.findById(nuevoTurno.getId());
	    }
	 
     public Turno deleteTurnoById(String id)  throws TurnoNotFoundException {
		 
		 Turno deletedTurno = turnoRepository.findByUUID(id);
		 
		 	if(deletedTurno == null) {
		 		
		 		throw new TurnoNotFoundException("Turno with id " + id + "not found ");
		 	
		 	}
		 
		 turnoRepository.delete(deletedTurno);
		 
		 return deletedTurno;
	 }
	 
	 
	 public Turno updateTurno(String id, TurnoDTO turnoDTO ) throws TurnoNotFoundException {
		 
		 Turno updatedTurno = turnoRepository.findByUUID(id);
		 
		 	if(updatedTurno == null) {
		 		
		 		throw new TurnoNotFoundException("Turno with id " + id + "not found ");
		 	
		 	}
		 
		 // Para el caso de un solo campo ?
	     //pacienteRepository.getEntityManager().merge(pacienteDTO);
		 
		 updatedTurno.setDomicilioConsulta(turnoDTO.getDomicilioConsulta());
		 updatedTurno.setFechaHoraTurno(turnoDTO.getFechaHoraTurno());
		
		 turnoRepository.persist(updatedTurno); 
		 return updatedTurno;
	 }
}
