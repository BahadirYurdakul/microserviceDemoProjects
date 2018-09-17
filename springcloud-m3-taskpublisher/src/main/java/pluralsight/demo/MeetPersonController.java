package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetPersonController {

	
    @Autowired
    MeetPersonSource meetPersonSource;
 
    @RequestMapping("/meetPerson")
    @ResponseBody
    public String meetPerson(@RequestBody Person person){
    	Message<String> message = MessageBuilder.withPayload(person.toString()).build();
    	System.out.println("message builded successfully");
    	meetPersonSource.meetPersonChannel().send(message);
        System.out.println(person.toString());
        return "Publisher person meet message sent!";
    }
	
	/*
	@Autowired
	private MeetPersonPublisher publisher;
	
	@RequestMapping(path="/meetPerson", method=RequestMethod.POST)
	public @ResponseBody String launchTask(@RequestBody String s) {
		publisher.publishRequest(s);	
		System.out.println("request made");
		return "success";
	}
	*/
}
