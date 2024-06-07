package org.umsaback.models.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private Date fechaNacimiento;
}
