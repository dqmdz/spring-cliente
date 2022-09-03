/**
 * 
 */
package ar.edu.um.programacion2.cliente.service.extern;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ar.edu.um.programacion2.cliente.model.Persona;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class PersonaService {

	public Persona guardarPersona(Persona persona) {
		log.debug("Guarda Persona");

		WebClient webClient = WebClient.builder().baseUrl("http://127.0.0.1:8085/persona")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

		Mono<Persona> response = webClient.post()
				.uri("/")
				.body(Mono.just(persona), Persona.class)
				.retrieve()
				.bodyToMono(Persona.class);
		
		return response.block();
	}

}
