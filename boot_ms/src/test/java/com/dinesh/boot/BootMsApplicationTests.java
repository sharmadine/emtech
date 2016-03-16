package com.dinesh.boot;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootMsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
@DirtiesContext
public class BootMsApplicationTests {

	@Value("${local.server.port}")
	private int port;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void envEndpointNotHidden() throws Exception {
		Traverson traverson = new Traverson(new URI("http://localhost:" + this.port + "/user"), MediaTypes.HAL_JSON);
		String uName = traverson.follow("self").toObject("$.userName");
		assertEquals("Hello Dinesh!", uName);
	}

}
