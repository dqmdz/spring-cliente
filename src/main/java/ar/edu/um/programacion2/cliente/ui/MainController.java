/**
 * 
 */
package ar.edu.um.programacion2.cliente.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.programacion2.cliente.service.MainService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainService service;

	@GetMapping("/run")
	public ResponseEntity<String> appRun() {
		return new ResponseEntity<String>(service.run(), HttpStatus.OK);
	}
}
