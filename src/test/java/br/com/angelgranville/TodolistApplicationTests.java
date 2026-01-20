package br.com.angelgranville;

import br.com.angelgranville.entity.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@LocalServerPort
	private int port;

	private WebTestClient webTestClient;

	@BeforeEach
	void setup() {
		this.webTestClient = WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:" + port)
				.build();
	}


	@Test
	void testCreateSuccess() {
		var toDo = new ToDo("ToDo 1", "Teste de sucesso", false, 10);

		webTestClient.post().uri("/create")
				.bodyValue(toDo)
				.exchange()
				.expectStatus().isOk()
				.expectBody().jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(toDo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(toDo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(toDo.getRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(toDo.getPrioridade());
	}

	@Test
	void testCreateFailure(){
		var toDo = new ToDo("", "", false, 100);

		webTestClient.post().uri("/create")
				.bodyValue(toDo)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
