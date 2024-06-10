package org.umsaback.repositories;

import java.util.List;
import java.util.Optional;

import org.umsaback.enums.Especialidad;
import org.umsaback.models.entities.Doctor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorRepository implements PanacheRepository<Doctor>{
	
	public List<Doctor> findByName(String nombre) {
        return list("SELECT d.nombre, d.apellido, d.dni, d.especialidad FROM Doctor d WHERE d.nombre = ?1", nombre);
	}
	
	public List<Doctor> findByEspecialidad(Especialidad especialidad){
		return list("SELECT d.nombre, d.apellido, d.dni, d.especialidad FROM Doctor d WHERE d.especialidad = ?1", especialidad);
	}
	
	//public 
}
