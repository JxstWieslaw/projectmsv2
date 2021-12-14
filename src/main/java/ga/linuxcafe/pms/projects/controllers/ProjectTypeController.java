package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.projects.models.ProjectType;
import ga.linuxcafe.pms.projects.services.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class ProjectTypeController {

	@Autowired  private ProjectTypeService projectTypeService;

	@GetMapping("/projects/projectTypes")
	public String getProjectTypes(Model model) {
		List<ProjectType> projectTypeList = projectTypeService.getAll();
		model.addAttribute("projectTypes", projectTypeList);
		return "projects/projectType";
	}

	@PostMapping("/projects/projectTypes/addNew")
	public String addNew(ProjectType projectType) {
		projectTypeService.save(projectType);
		return "redirect:/projects/projectTypes";
	}

	@RequestMapping("/projects/projectTypes/findById")
	@ResponseBody
	public Optional<ProjectType> findById(int id) {
		return projectTypeService.getById(id);
	}

	@RequestMapping(value="/projects/projectTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(ProjectType projectType) {
		projectTypeService.save(projectType);
		return "redirect:/projects/projectTypes";
	}

	@RequestMapping(value="/projects/projectTypes/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String deleteForReal(@PathVariable Integer id){
		projectTypeService.delete(id);
		return "redirect:/projects/projectTypes";
	}
}
