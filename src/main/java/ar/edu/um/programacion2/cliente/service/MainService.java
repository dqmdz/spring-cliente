/**
 * 
 */
package ar.edu.um.programacion2.cliente.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.programacion2.cliente.model.Persona;
import ar.edu.um.programacion2.cliente.service.extern.PersonaService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class MainService {

	@Autowired
	private PersonaService personaService;

	public String run() {
		log.debug("MainService starting");
		Persona persona = new Persona(23456789L, "Pepe", "Honguito");
		log.debug("Persona -> {}", persona);
		persona = personaService.guardarPersona(persona);
		log.debug("MainService ending");
		return "Terminando";
	}

}
