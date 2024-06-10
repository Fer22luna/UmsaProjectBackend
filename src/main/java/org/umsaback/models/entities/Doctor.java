package org.umsaback.models.entities;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.umsaback.enums.Especialidad;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "doctores")
public class Doctor {
	
	@Id
	@UuidGenerator
	private String id;


	@Column
	private Especialidad especialidad;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos = new ArrayList<>();

	
	public Doctor() {}
	
	public Doctor(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	
	public Doctor(String nombre, String apellido, String dni, String domicilio, LocalDate fechaNacimiento, String celular, Especialidad especialidad) {
		super(nombre, apellido, dni, domicilio, fechaNacimiento,celular);
		this.especialidad=especialidad;
	}

}