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

	@GetMapping("/")
	public String dashboard() {
		return "landingPage";
	}

	@GetMapping("/_layout")
	public String layout() {
		return "_layout";
	}
	
	@GetMapping("/hr")
	public String hr() {
		return "hr/hrHome";
	}
	
	@GetMapping("/accounts")
	public String accounts() {
		return "accounts/accountsHome";
	}
	
	@GetMapping("/helpdesk")
	public String helpdesk() {
		return "helpdesk/helpdeskHome";
	}
	
	@GetMapping("/parameters")
	public String parameters() {
		return "parameters/parametersHome";
	}
	
	@GetMapping("/payroll")
	public String payroll() {
		return "payroll/payrollHome";
	}
	
	@GetMapping("/projects")
	public String projects() {
		return "projects/projectsHome";
	}
	
	@GetMapping("/security")
	public String security() {
		return "security/securityHome";
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
