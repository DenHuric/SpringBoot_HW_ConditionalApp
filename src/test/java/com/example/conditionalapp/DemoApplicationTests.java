package com.example.conditionalapp;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static GenericContainer devApp = new GenericContainer("devapp:latest")
            .withExposedPorts(8080);
    @Container
    private static GenericContainer prodApp = new GenericContainer("prodapp:latest")
            .withExposedPorts(8081);

    @Test
    public void contextLoads() {
        int devPort = devApp.getMappedPort(8080);
        int prodPort = prodApp.getMappedPort(8081);
        ResponseEntity<String> devResponse = restTemplate.getForEntity("http://localhost:" + devPort + "/profile", String.class);
        ResponseEntity<String> prodResponse = restTemplate.getForEntity("http://localhost:" + prodPort  + "/profile", String.class);
        Assert.assertEquals("Current profile is dev",devResponse.getBody());
        Assert.assertEquals("Current profile is production",prodResponse.getBody());
    }
}
