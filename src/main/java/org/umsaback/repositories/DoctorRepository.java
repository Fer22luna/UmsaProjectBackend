package org.umsaback.repositories;

import java.util.List;

import org.umsaback.enums.Especialidad;
import org.umsaback.models.entities.Doctor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorRepository implements PanacheRepository<Doctor>{
	
	public List<Doctor> findByName(String name) {
        return list("SELECT d.nombre, d.apellido, d.dni, d.especialidad FROM Doctor d WHERE d.nombre = ?1", name);
	}
	

	public Doctor findByUUID(String id) {
		return find("id",id).firstResult();
	}
	

	public List<Doctor> findByEspecialidad(Especialidad specialty){
		return list("SELECT d.nombre, d.apellido, d.dni, d.especialidad FROM Doctor d WHERE d.especialidad = ?1", specialty);
	}
	

}
