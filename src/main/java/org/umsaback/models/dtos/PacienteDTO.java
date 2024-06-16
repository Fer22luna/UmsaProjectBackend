package org.umsaback.models.dtos;
import java.time.LocalDate;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(hidden=true)
public class PacienteDTO {

	
	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private LocalDate fechaNacimiento;
	private String celular;
	@NotBlank()
	private String obraSocial;
	@NotBlank(message="cuit es requerido")
	private String cuit;
	
	public PacienteDTO() {}

	public PacienteDTO(String nombre, String apellido, String dni, String domicilio, LocalDate fechaNacimiento, String celular,
			 String obraSocial, String cuit) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.obraSocial = obraSocial;
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
	
	
}

