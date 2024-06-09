package org.umsaback.models.entities;



import org.hibernate.annotations.UuidGenerator;
import org.umsaback.enums.Especialidad;
import org.umsaback.models.utils.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "doctores")
public class Doctor extends Persona{
	
	@Id
	@UuidGenerator
	private String id;
	
	
	@Column
	private Especialidad especialidad;
	
}
