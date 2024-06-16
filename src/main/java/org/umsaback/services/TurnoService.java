package org.umsaback.services;

import java.util.List;

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
	 
	 public Turno findById(String id){
		 
			return turnoRepository.findByUUID(id);
		}	 
	 
	
	 public Turno createTurno(TurnoDTO turnoDTO) {

		 	Doctor doctorTurno = doctorRepository.findByUUID(turnoDTO.getDoctorId());
		 	
		 	Paciente pacienteTurno = pacienteRepository.findByUUID(turnoDTO.getPacienteId());
		 
		 	Turno nuevoTurno = new Turno(turnoDTO.getFechaHoraTurno(), doctorTurno, turnoDTO.getDomicilioConsulta(), turnoDTO.getEstadoTurno(), pacienteTurno);
		 	
		 	turnoRepository.persist(nuevoTurno);
		
	        return turnoRepository.findById(nuevoTurno.getId());
	    }
	 
public Turno deleteTurnoById(String id) {
		 
		 Turno deletedTurno = turnoRepository.findByUUID(id);
		 
		 turnoRepository.delete(deletedTurno);
		 
		 return deletedTurno;
	 }
	 
	 
	 public Turno updateTurno(String id, TurnoDTO turnoDTO ) {
		 
		 Turno updatedTurno = turnoRepository.findByUUID(id);
		 
		 // Para el caso de un solo campo ?
	     //pacienteRepository.getEntityManager().merge(pacienteDTO);
		 
		 updatedTurno.setDomicilioConsulta(turnoDTO.getDomicilioConsulta());
		 updatedTurno.setFechaHoraTurno(turnoDTO.getFechaHoraTurno());
		
		 turnoRepository.persist(updatedTurno); 
		 return updatedTurno;
	 }
}
