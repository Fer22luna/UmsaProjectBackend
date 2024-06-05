package org.umsaback.models.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity		
@Table(name = "paciente")
public class Paciente {

	
	@Id
	@GeneratedValue(generator = "uuid") 
    private String id;
	
	@Column( length = 100)
	private String obraSocial;
	
	
	// Despues con lombok le ponemos los getters, setter y constructores.
}
