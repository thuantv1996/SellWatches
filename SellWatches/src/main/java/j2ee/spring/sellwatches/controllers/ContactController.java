package j2ee.spring.sellwatches.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import j2ee.spring.sellwatches.services.ContactService;
import j2ee.spring.sellwatches.viewmodel.ContactViewModel;

@Controller
@Component
public class ContactController {

	@Autowired
	private ContactService service;
	
	@RequestMapping("/contact")
	public String index() {
		return "contact";
	}
	
	@RequestMapping(value = "/send",method = RequestMethod.POST)
	public String send(@ModelAttribute("contact") ContactViewModel contact)
	{
		// Gọi service gửi mail
		boolean result = service.sendMessage(contact);
		if(result)
			return "redirect:/";
		else
			return "redirect:/contact";
	}
}
