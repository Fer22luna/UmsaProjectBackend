package org.umsaback.models.entities;

import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {

	@Id
	@UuidGenerator
	private String id;
	
	@Column
	private LocalDate fechaHoraTurno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	@JsonBackReference
	private Doctor doctor;
	
	@Column
	private String domicilioConsulta;
	
	@Column
	private Boolean estadoTurno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "paciente_id", nullable = false)
	@JsonBackReference
	private Paciente paciente;

	
	
	public Turno() {
		
	}
	
	public Turno( LocalDate fechaHoraTurno, Doctor doctor, String domicilioConsulta, Boolean estadoTurno,
			Paciente paciente) {
		
		this.fechaHoraTurno = fechaHoraTurno;
		this.doctor = doctor;
		this.domicilioConsulta = domicilioConsulta;
		this.estadoTurno = estadoTurno;
		this.paciente = paciente;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public LocalDate getFechaHoraTurno() {
		return fechaHoraTurno;
	}



	public void setFechaHoraTurno(LocalDate fechaHoraTurno) {
		this.fechaHoraTurno = fechaHoraTurno;
	}



	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public String getDomicilioConsulta() {
		return domicilioConsulta;
	}



	public void setDomicilioConsulta(String domicilioConsulta) {
		this.domicilioConsulta = domicilioConsulta;
	}



	public Boolean getEstadoTurno() {
		return estadoTurno;
	}



	public void setEstadoTurno(Boolean estadoTurno) {
		this.estadoTurno = estadoTurno;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	
}
