package j2ee.spring.sellwatches.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
public class Register {

	@RequestMapping("/Register")
	public String Default() {
		return "register";
	}
}
