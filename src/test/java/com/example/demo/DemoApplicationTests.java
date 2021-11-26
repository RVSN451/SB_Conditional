package com.example.demo;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate testTemplate;

	private static int devAppPort = 8080;
	private static int prodAppPort = 8081;

	@Container
	private static GenericContainer<?> devApp =
			new GenericContainer<>("devapp")
					.withExposedPorts(devAppPort);

	@Container
	private static GenericContainer<?> prodApp =
			new GenericContainer<>("productionapp")
					.withExposedPorts(prodAppPort);



	@Test
	void devAppTest() {
		final String expected = "Current profile is dev";
		String url = String.format("http://localhost:%d/profile", devApp.getMappedPort(devAppPort));
		ResponseEntity<String> forEntity = testTemplate.getForEntity(url, String.class);
		Assertions.assertEquals(expected, forEntity.getBody());
	}

	@Test
	void prodAppTest() {
		final String expected = "Current profile is production";
		String url = String.format("http://localhost:%d/profile", prodApp.getMappedPort(prodAppPort));
		ResponseEntity<String> forEntity = testTemplate.getForEntity(url, String.class);
		Assertions.assertEquals(expected, forEntity.getBody());
	}

}
