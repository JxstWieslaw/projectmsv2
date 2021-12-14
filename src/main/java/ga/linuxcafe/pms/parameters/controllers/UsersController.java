package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Users;
import ga.linuxcafe.pms.parameters.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsersController {

	@Autowired
	private UsersService userService;

	//Modified method to Add a new User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(Users user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView  redirectView= new RedirectView("/login",true);
		redir.addFlashAttribute("message",
				"You successfully registered! You can now login");
		return redirectView;
	}

}
