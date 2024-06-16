package org.umsaback.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.UuidGenerator;
import org.umsaback.models.utils.Persona;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
//import lombok.NoArgsConstructor;


@Schema(description = "Entity representation of Patient")
@Data
@Entity		
@Table(name = "pacientes")
public class Paciente extends Persona{

	@Id
	@UuidGenerator
	@Schema(description = "ID UUID")
    private String id;
	
	@Column( length = 100)
	private String obraSocial;
	
	@Column
	@NotBlank(message="cuit es requerido")
	private String cuit;
	
	 @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonBackReference
	private  List<Turno> turnos = new ArrayList<>();

	public Paciente() {}
	 
	public Paciente( String nombre, String apellido,String dni, String domicilio, LocalDate fechaNacimiento,
			String celular, String obraSocial, String cuit) {
			super(nombre,apellido,dni,domicilio,fechaNacimiento,celular);
	        this.obraSocial = obraSocial;
	        this.cuit = cuit;
	        this.turnos = new ArrayList<>();
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


	public List<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}


	
	
}
