package sqa.springopencartconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringOpencartConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOpencartConfigServerApplication.class, args);
	}

}
