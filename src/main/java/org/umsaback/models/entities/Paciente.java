package org.umsaback.models.entities;
//import java.util.UUID;

//import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity		
@Table(name = "paciente")
public class Paciente {

	@Id
	//@GeneratedValue(generator = "uuid") 
	//@GenericGenerator(name = "uuid", strategy = "uuid2")
	@UuidGenerator
    private String id;
	
	@Column( length = 100)
	private String obraSocial;
	
	@Column
	@NotBlank(message="cuit es requerido")
	private String cuit;
		
	public Paciente(){}
	
	public Paciente(String obraSocial,String cuit) {
		this.obraSocial = obraSocial;
		this.cuit = cuit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
	
	
	
	// Despues con lombok le ponemos los getters, setter y constructores.
}
