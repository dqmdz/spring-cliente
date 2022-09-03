/**
 * 
 */
package ar.edu.um.programacion2.cliente.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable {
	
	private static final long serialVersionUID = -1266332059815866076L;
	
	private Long documento;
	private String nombre;
	private String apellido;
	
}
