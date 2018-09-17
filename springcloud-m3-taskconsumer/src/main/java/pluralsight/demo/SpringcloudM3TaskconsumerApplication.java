package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringcloudM3TaskconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM3TaskconsumerApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT)
	public void meetPerson(String person) throws Exception{
		System.out.println("Consumer! I have alread met person: " + person);
	}
}
