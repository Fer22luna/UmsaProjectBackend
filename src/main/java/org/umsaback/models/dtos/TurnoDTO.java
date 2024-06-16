package org.umsaback.models.dtos;

import java.time.LocalDate;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Schema(hidden=true)
public class TurnoDTO {

	@NotBlank(message="Fecha es requerido")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaHoraTurno;
	@NotBlank
    private String doctorId;
	@NotBlank
    private String domicilioConsulta;
	@NotBlank
    private Boolean estadoTurno;
	@NotBlank
    private String pacienteId;
	
	public TurnoDTO() {
		
	}
	
	
	public TurnoDTO(LocalDate fechaHoraTurno, String doctorId,
			 String domicilioConsulta, Boolean estadoTurno,  String pacienteId) {
		super();
		this.fechaHoraTurno = fechaHoraTurno;
		this.doctorId = doctorId;
		this.domicilioConsulta = domicilioConsulta;
		this.estadoTurno = estadoTurno;
		this.pacienteId = pacienteId;
	}
	public LocalDate getFechaHoraTurno() {
		return fechaHoraTurno;
	}
	public void setFechaHoraTurno(LocalDate fechaHoraTurno) {
		this.fechaHoraTurno = fechaHoraTurno;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
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
	public String getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	
	
}
