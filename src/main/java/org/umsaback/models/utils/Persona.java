package org.umsaback.models.utils;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private Date fechaNacimiento;

}
