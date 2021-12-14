package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProjectCountController {

	@Autowired  private EmployeeService employeeService;

	@GetMapping("/projects/projectCount")
	public String getProjectTypes(Model model) {
		model.addAttribute("employeesListProjectCnt", employeeService.employeeProjects());
		return "projects/projectCount";
	}
}
