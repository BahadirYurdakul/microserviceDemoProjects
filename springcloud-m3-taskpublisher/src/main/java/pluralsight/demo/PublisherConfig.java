package pluralsight.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {
	
	@Bean
	public MeetPersonPublisher meetPersonPublisher() {
		return new MeetPersonPublisher();
	}

}
