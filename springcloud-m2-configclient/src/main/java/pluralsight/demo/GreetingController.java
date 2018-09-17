package pluralsight.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RefreshScope
public class GreetingController {
	
	@Value("${greeting}")
	String greetings;
	
	@Value("${connstring}")
	String connstring;

	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String getRate(Model m) {
		m.addAttribute("greetings", greetings);
		m.addAttribute("connstring", connstring);
		//name of the view.
		return "greetingview";
	}

}
