/**
 * 
 */
package ar.edu.um.programacion2.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.programacion2.cliente.model.Persona;
import ar.edu.um.programacion2.cliente.service.PersonaService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/personaCliente")
@Slf4j
public class PersonaClienteController {

	@Autowired
	private PersonaService service;

	@GetMapping("/")
	public ResponseEntity<List<Persona>> findAll() {
		return new ResponseEntity<List<Persona>>(service.todos(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Persona> add(@RequestBody Persona persona) {
		return new ResponseEntity<Persona>(service.agregar(persona), HttpStatus.OK);
	}

	@PutMapping("/{documento}")
	public ResponseEntity<Persona> update(@RequestBody Persona persona, @PathVariable Long documento) {
		return new ResponseEntity<Persona>(service.modificar(persona, documento), HttpStatus.OK);
	}

	@DeleteMapping("/{documento}")
	public ResponseEntity<Boolean> deleteByDocumento(@PathVariable Long documento) {
		log.debug("Eliminando cliente {}", documento);
		return new ResponseEntity<Boolean>(service.eliminar(documento), HttpStatus.OK);
	}

}
