package org.umsaback.models.dtos;

import org.umsaback.enums.Especialidad;

public class DoctorDTO {
	
	private Especialidad especialidad;

	
	
	public DoctorDTO() {}
	
	public DoctorDTO(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
	

}
