package org.umsaback.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;



@OpenAPIDefinition(
	    info = @Info(
	        title="Umsa project ",
	        version = "1.0.0",
	        contact = @Contact(
	            name = "Umsa - Softtek",
	            url = "http://exampleurl.com/contact")
	 ))

@ApplicationPath("/api")
public class SwaggerConfig extends Application{

}
