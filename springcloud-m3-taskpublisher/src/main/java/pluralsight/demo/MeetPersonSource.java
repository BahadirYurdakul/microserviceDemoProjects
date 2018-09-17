package pluralsight.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MeetPersonSource {
	
    @Output("meetPersonChannel")
    MessageChannel meetPersonChannel();

}
