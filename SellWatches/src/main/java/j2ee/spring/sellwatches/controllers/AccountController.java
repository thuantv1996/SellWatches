package j2ee.spring.sellwatches.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import j2ee.spring.sellwatches.common.CommonConstands;
import j2ee.spring.sellwatches.common.Encryptor;
import j2ee.spring.sellwatches.impl.AccountServiceImplement;
import j2ee.spring.sellwatches.viewmodel.LoginViewModel;
import j2ee.spring.sellwatches.viewmodel.RegisterViewModel;

@Controller
@Component
@SessionAttributes(CommonConstands.USER_SESSION)
public class AccountController {

	@Autowired
	AccountServiceImplement accountService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/Login")
	public String Login() {	
		return "account";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Login")
	public String Login(@Valid @ModelAttribute LoginViewModel loginViewModel, BindingResult result, ModelMap modelMap) {
		
//		RedirectView redirectLogin = new RedirectView("/Login");
		if(result.hasErrors()) {
			return "account";
		}
		
		boolean checkLogin = accountService.LoginAccount(loginViewModel.getUserName(), Encryptor.MD5Hash(loginViewModel.getPassWord()));
		
		if(checkLogin) {
			modelMap.addAttribute(CommonConstands.USER_SESSION, loginViewModel.getUserName());
//			RedirectView redirect = new RedirectView("/SellWatches");
//			redirect.setExposeModelAttributes(false);
			return "redirect:/";
		}else {
			modelMap.addAttribute("checkLogin", "Sai tên tài khoản hoặc mật khẩu");
		}
		return "account";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Register")
	public String Register() {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Register")
	public String Register(@Valid @ModelAttribute RegisterViewModel registerViewModel, BindingResult result, ModelMap modelMap)
	{	
//		if(registerViewModel.getFirstName() == null || registerViewModel.getLastName() == null ||
//			registerViewModel.getEmail() == null || registerViewModel.getAddress() == null ||
//			registerViewModel.getNumberPhone() == null || registerViewModel.getUserName() == null ||
//			registerViewModel.getPassWord() == null || registerViewModel.getSex() == null)
//		{
//			return "register";
//		}
		
		if(result.hasErrors()) {
			return "register";
		}
		
		if(accountService.isExistAccount(registerViewModel.getUserName()))
		{
			modelMap.addAttribute("isExistAccount", "Tài khoản đã tồn tại");
			return "register";
		}
		
		if(!accountService.isValidPassword(registerViewModel.getPassWord()))
		{
			modelMap.addAttribute("isValidPassWord", "Mật khẩu phải gồm cả chữ và số");
			return "register";
		}
		
		boolean checkRegister = accountService.RegisterAccount(registerViewModel);
		if(checkRegister) {
			modelMap.addAttribute("checkRegister", "Tạo tài khoản thành công");
		}else {
			modelMap.addAttribute("checkRegister", "Tạo tài khoản thất bại");
		}
		
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Logout")
	public String Logout(@SessionAttribute(CommonConstands.USER_SESSION) String userSession, ModelMap modelMap, HttpSession httpSession)
	{
		if(httpSession.getAttribute(CommonConstands.USER_SESSION) != null)
		{
			modelMap.addAttribute(CommonConstands.USER_SESSION, "");
		}	
		return "redirect:/";
	}
	
}
