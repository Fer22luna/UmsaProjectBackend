package org.umsaback.repositories;


import jakarta.enterprise.context.ApplicationScoped;
import org.umsaback.models.entities.Paciente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.List;


@ApplicationScoped  //Annotation marking the class as CDI bean
public class PacienteRepository implements PanacheRepositoryBase<Paciente, String>{
	
	
	public List<Paciente> listAll(String Id){
		return findAll().list();
	}

	public Paciente findByCuit(String cuit){
		return find("cuit",cuit).firstResult();
	}
	
	public Paciente findByUUID(String id){
		return find("id",id).firstResult();
	}
	
}
