package org.umsaback.models.entities;
//import java.util.UUID;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.umsaback.models.utils.Persona;

//import org.hibernate.annotations.GenericGenerator;
//import jakarta.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
@Entity		
@Table(name = "pacientes")
public class Paciente extends Persona{

	@Id
	@UuidGenerator
    private String id;
	
	@Column( length = 100)
	private String obraSocial;
	
	@Column
	@NotBlank(message="cuit es requerido")
	private String cuit;
	
	 @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonBackReference
	private  List<Turno> turnos = new ArrayList<>();

	 
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
	
    public Paciente(){}

	
	
}
