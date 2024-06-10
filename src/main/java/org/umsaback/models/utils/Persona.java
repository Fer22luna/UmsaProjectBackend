package org.umsaback.models.utils;

import java.time.LocalDate;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class Persona {
	
	@Column @NotNull
	private String nombre;
	@Column @NotNull
	private String apellido;
	@Column(unique = true)
	private String dni;
	@Column 
	private String domicilio;
	@Column 
	private LocalDate fechaNacimiento;
	@Column
	private String celular;
	
	public Persona() {}
		
	public Persona(String nombre, String apellido, String dni, String domicilio, LocalDate fechaNacimiento,
			String celular) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
	}

	
	
}
