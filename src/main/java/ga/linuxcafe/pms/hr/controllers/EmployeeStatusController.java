package ga.linuxcafe.pms.hr.controllers;

import ga.linuxcafe.pms.hr.models.EmployeeStatus;
import ga.linuxcafe.pms.hr.services.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeStatusController {

	@Autowired  private EmployeeStatusService employeeStatusService;

	@GetMapping("/hr/employeeStatuses")
	public String getEmployeeStatuses(Model model) {
		List<EmployeeStatus> employeeStatusList = employeeStatusService.getAll();
		model.addAttribute("employeeStatuses", employeeStatusList);
		return "hr/employeeStatus";
	}

	@PostMapping("/hr/employeeStatuses/addNew")
	public String addNew(EmployeeStatus employeeStatus) {
		employeeStatusService.save(employeeStatus);
		return "redirect:/hr/employeeStatuses";
	}

	@RequestMapping("/hr/employeeStatuses/findById")
	@ResponseBody
	public Optional<EmployeeStatus> findById(int id) {
		return employeeStatusService.getById(id);
	}

	@RequestMapping(value="/hr/employeeStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeStatus employeeStatus) {
		employeeStatusService.save(employeeStatus);
		return "redirect:/hr/employeeStatuses";
	}

	@RequestMapping(value="/hr/employeeStatuses/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String deleteForReal(@PathVariable Integer id){
		employeeStatusService.delete(id);
		return "redirect:/hr/employeeStatuses";
	}
}
