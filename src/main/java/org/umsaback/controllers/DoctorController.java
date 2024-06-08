package org.umsaback.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/doctor")
public class DoctorController {
	
	@GET
	public String saludar() {
		return "Hola soy un doctor";
	}
}
