package ga.linuxcafe.pms.hr.controllers;

import ga.linuxcafe.pms.hr.models.JobRole;
import ga.linuxcafe.pms.hr.services.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobRoleController {

	@Autowired  private JobRoleService jobRoleService;

	@GetMapping("/hr/jobRoles")
	public String getJobRoles(Model model) {
		List<JobRole> jobRoleList = jobRoleService.getAll();
		model.addAttribute("jobRoles", jobRoleList);
		return "hr/jobRole";
	}

	@PostMapping("/hr/jobRoles/addNew")
	public String addNew(JobRole jobRole) {
		jobRoleService.save(jobRole);
		return "redirect:/hr/jobRoles";
	}

	@RequestMapping("/hr/jobRoles/findById")
	@ResponseBody
	public Optional<JobRole> findById(int id) {
		return jobRoleService.getById(id);
	}

	@RequestMapping(value="/hr/jobRoles/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobRole jobRole) {
		jobRoleService.save(jobRole);
		return "redirect:/hr/jobRoles";
	}

	@RequestMapping(value="/hr/jobRoles/delete/{id}", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		jobRoleService.delete(id);
		return "redirect:/hr/jobRoles";
	}
}
