package pluralsight.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MeetPersonSource.class)
public class MeetPersonPublisher {
	
	
	/*
	//rabbit mq queue
	@Autowired
	private Source source;

	public void publishRequest(String payload) {
		
		//TODO get it from config server
		String url = "maven://pluralsight.demo:springcloud-m3-task:jar:0.0.1-SNAPSHOT";
		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		//task request created
		TaskLaunchRequest request = new TaskLaunchRequest(url, input, null, null, null);
		System.out.println("created task request");
		
		//creating message
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		//sending message
		this.source.output().send(message);
	}
	*/
}
