package org.umsaback.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/paciente")
public class PacienteController {
	
	
	@GET()
	public String getPaciente() {
		return "aca retornan los pacientes";
	}
	

}
