package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudM6EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM6EurekaserverApplication.class, args);
	}
}
