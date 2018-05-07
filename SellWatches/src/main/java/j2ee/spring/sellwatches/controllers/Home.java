package j2ee.spring.sellwatches.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.services.AccountService;

@Controller
@Component
public class Home {
	
	private AccountService service;
	
	@Autowired
	public Home (AccountService service)
	{
		this.service =service;
	}
	@RequestMapping("/Index")
	public String Index(Model model)
	{
		List<Account> list = service.getList();
		System.out.println(list.size());
		return "home";
	}
}
