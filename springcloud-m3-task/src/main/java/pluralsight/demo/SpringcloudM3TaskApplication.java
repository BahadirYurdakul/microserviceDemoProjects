package pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringcloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM3TaskApplication.class, args);
	}
	
	//It registers the PersonProcessingTask with spring to make available
	@Bean
	public PersonProcessingTask personProcessingTask() {
		return new PersonProcessingTask();
	}
	
	public class PersonProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {	
			//parameters personid, timestamp
			if(args != null) {
				String personId = args[0];
				String timestamp = args[1];
				
				System.out.println("parameter count is " + args.length);
				System.out.println("Person id is " + personId + " timestamp is " + timestamp);
			}	
		}	
		
	}
}
