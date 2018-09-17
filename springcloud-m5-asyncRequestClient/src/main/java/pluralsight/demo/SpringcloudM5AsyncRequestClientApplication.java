package pluralsight.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringcloudM5AsyncRequestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM5AsyncRequestClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
	RestTemplate webTemplate;
	
	@RequestMapping(value="/getGreeting", method=RequestMethod.GET)
	public @ResponseBody String getGreeting() throws InterruptedException, ExecutionException {
		ResponseEntity<String> greeting = webTemplate.getForEntity("http://localhost:8080/greetings", String.class);
		return greeting.getBody();
	}
	
}
