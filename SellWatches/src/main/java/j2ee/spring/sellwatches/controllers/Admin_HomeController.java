package j2ee.spring.sellwatches.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import j2ee.spring.sellwatches.common.CommonConstands;

@Controller
@Component
@SessionAttributes(CommonConstands.ADMIN_SESSION)
public class Admin_HomeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/home")
	public String Default(HttpSession httpSession) {
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: login ";
		}
		return "admin_index";
	}

}
