/*
 * Copyright (c) 2020. Property of Honeywell, Inc.
*/
package hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TodoControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

    @LocalServerPort
    int randomServerPort;

	@Test
	public void testFlightplansAPI() throws Exception {
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/hello";
		 URI uri = new URI(baseUrl);
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.
		  getForEntity(uri, String.class);
		  
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello service");
	}

}
