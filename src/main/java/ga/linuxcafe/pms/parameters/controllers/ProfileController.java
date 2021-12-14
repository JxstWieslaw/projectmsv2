package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/profile")
    public String profile(Model model, Principal principal){
        String username= principal.getName();
        model.addAttribute("employee",employeeService.findByUsername(username));
        return "profile";
    }
}
