package ga.linuxcafe.pms.parameters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

	@GetMapping("/pageNotFound")
	public String pageNotFound() {
		return "pageNotFound";
	}

	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	@GetMapping("/_layout")
	public String layout() {
		return "_layout";
	}
	
	@GetMapping("/hr")
	public String hr() {
		return "/hr/index";
	}
	
	@GetMapping("/accounts")
	public String accounts() {
		return "/accounts/index";
	}
	
	@GetMapping("/helpdesk")
	public String helpdesk() {
		return "/helpdesk/index";
	}
	
	@GetMapping("/parameters")
	public String parameters() {
		return "/parameters/index";
	}
	
	@GetMapping("/payroll")
	public String payroll() {
		return "/payroll/index";
	}
	
	@GetMapping("/projects")
	public String projects() {
		return "/projects/index";
	}
	
	@GetMapping("/security")
	public String security() {
		return "/security/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgot-password";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	
}
