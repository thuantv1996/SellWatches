package j2ee.spring.sellwatches.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import j2ee.spring.sellwatches.impl.OrderServiceImplement;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.services.Orderservice;

@Controller
@Component
public class Home {
	
	private OrderServiceImplement service;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	@Autowired
	public Home (OrderServiceImplement service)
	{
		this.service =service;
	}
	@RequestMapping("/Index")
	public String Index(Model model)
	{
		List<Order> list = service.select();
		System.out.println(list.size());
		Timestamp s = list.get(0).getDeliveryDay();
		System.out.println(s);
		return "home";
	}
}
