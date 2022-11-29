package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Reservation {
	@RequestMapping(value="/Reservation" ,method = RequestMethod.GET)
	public String getFirstView() {
		return "Reservation";
	}



}
