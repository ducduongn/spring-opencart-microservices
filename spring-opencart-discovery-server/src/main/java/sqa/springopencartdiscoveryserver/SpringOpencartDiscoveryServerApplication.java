package sqa.springopencartdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringOpencartDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOpencartDiscoveryServerApplication.class, args);
	}

}
