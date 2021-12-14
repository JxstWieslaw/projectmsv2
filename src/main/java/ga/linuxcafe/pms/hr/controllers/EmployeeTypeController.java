package ga.linuxcafe.pms.hr.controllers;

import ga.linuxcafe.pms.hr.models.EmployeeType;
import ga.linuxcafe.pms.hr.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class EmployeeTypeController {

	@Autowired  private EmployeeTypeService employeeTypeService;

	@GetMapping("/hr/employeeTypes")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> employeeTypeList = employeeTypeService.getAll();
		model.addAttribute("employeeTypes", employeeTypeList);
		return "hr/employeeType";
	}

	@PostMapping("/hr/employeeTypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/hr/employeeTypes";
	}

	@RequestMapping("/hr/employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
	  return employeeTypeService.getById(id);
	}

	@RequestMapping(value="/hr/employeeTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/hr/employeeTypes";
	}

	@RequestMapping(value="/hr/employeeTypes/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		employeeTypeService.delete(id);
		return "redirect:/hr/employeeTypes";
	}
}
