package ga.linuxcafe.pms.security.controllers;

import ga.linuxcafe.pms.security.models.Users;
import ga.linuxcafe.pms.security.services.RoleService;
import ga.linuxcafe.pms.security.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsersController {

	@Autowired
	private UsersService userService;

	@Autowired
	private RoleService roleService;

	//Modified method to Add a new User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(Users user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView  redirectView= new RedirectView("/login",true);
		redir.addFlashAttribute("message",
				"You successfully registered! You can now login");
		return redirectView;
	}

	@GetMapping("/security/users")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getAll());
		model.addAttribute("userRoles", roleService.getAll());
		model.addAttribute("userNotRoles", roleService.getAll());
		return "security/users";
	}

	//View New Users Form
	@GetMapping("/security/userAdd")
	public String addUser(){
		return "security/userAdd";
	}

	@PostMapping("/security/users/save")
	public String addNew(Users user) {
		userService.save(user);
		return "redirect:/security/users";
	}

	@GetMapping("/security/userEdit/{id}")
	public String editEmployee(@PathVariable Integer id, Model model){
		Users user = userService.getById(id);
		model.addAttribute("user", user);
		model.addAttribute("userRoles", roleService.getUserRoles(user));
		model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
		return "security/userEdit";
	}
	//Delete A user
	@RequestMapping(value="/security/users/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		userService.delete(id);
		return "redirect:/security/users";
	}
}
