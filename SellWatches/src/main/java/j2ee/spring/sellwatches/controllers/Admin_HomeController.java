package j2ee.spring.sellwatches.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class Admin_HomeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/home")
	public String Default() {
		return "admin_index";
	}

}
