package org.umsaback.repositories;


import java.util.List;

import org.umsaback.models.entities.Turno;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class TurnoRepository implements PanacheRepositoryBase<Turno, String>{

	
	public List<Turno> listAll(String Id){
		return findAll().list();
	}
	
	
}
