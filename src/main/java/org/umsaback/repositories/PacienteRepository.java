package org.umsaback.repositories;


import jakarta.enterprise.context.ApplicationScoped;
import org.umsaback.models.entities.Paciente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.List;
import java.util.Optional;


@ApplicationScoped  //Annotation marking the class as CDI bean
public class PacienteRepository implements PanacheRepositoryBase<Paciente, String>{
	
	
	public List<Paciente> listAll(String Id){
		return findAll().list();
	}

	public Optional<Paciente> findByCuit(String cuit){
		return find("cuit",cuit).firstResultOptional();
	}
	
}
