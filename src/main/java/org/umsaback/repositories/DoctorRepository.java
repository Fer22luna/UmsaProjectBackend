package org.umsaback.repositories;

import java.util.List;

import org.umsaback.models.entities.Doctor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorRepository implements PanacheRepository<Doctor>{
	
	public List<Doctor> buscarPorNombre(String nombre){
		return list("nombre",nombre);
	}
	
	public Doctor findByUUID(String id) {
		return find("id",id).firstResult();
	}
	
}
