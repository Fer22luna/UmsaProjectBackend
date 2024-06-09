package org.umsaback.models.entities;

import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;
import org.umsaback.enums.Especialidad;
import org.umsaback.models.utils.Persona;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "doctores")
public class Doctor extends Persona{
	
	@Id
	@UuidGenerator
	private String id;
	
	
	@Column @NotNull
	private Especialidad especialidad;
	
	public Doctor(String nombre, String apellido, String dni, String domicilio, LocalDate fechaNacimiento, String celular, Especialidad especialidad) {
		super(nombre, apellido, dni, domicilio, fechaNacimiento,celular);
		this.especialidad=especialidad;
	}
}


