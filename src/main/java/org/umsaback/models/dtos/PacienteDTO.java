package org.umsaback.models.dtos;
import jakarta.validation.constraints.NotBlank;

public class PacienteDTO {

	@NotBlank()
	private String obraSocial;
	@NotBlank(message="cuit es requerido")
	private String cuit;
	
	public PacienteDTO() {}
	
	public PacienteDTO(String obraSocial,String cuit) {
		this.obraSocial = obraSocial;
		this.cuit = cuit;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	
	
	
}

