package ga.linuxcafe.pms.hr.controllers;

import ga.linuxcafe.pms.hr.models.Employee;
import ga.linuxcafe.pms.hr.services.EmployeeService;
import ga.linuxcafe.pms.hr.services.EmployeeStatusService;
import ga.linuxcafe.pms.hr.services.EmployeeTypeService;
import ga.linuxcafe.pms.hr.services.JobRoleService;
import ga.linuxcafe.pms.parameters.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private JobRoleService jobRoleService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeStatusService employeeStatusService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private TitleService titleService;
	@Autowired
	private MaritalStatusService maritalStatusService;

	public Model addModelAttributes(Model model){
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("jobRoles", jobRoleService.getAll());
		model.addAttribute("employeeTypes", employeeTypeService.getAll());
		model.addAttribute("employeeStatuses", employeeStatusService.getAll());
		model.addAttribute("genders", genderService.getAll());
		model.addAttribute("titles", titleService.getAll());
		model.addAttribute("maritalStatuses", maritalStatusService.getAll());
		return model;
	}

	//View Employee List form.
	@GetMapping("/hr/employees")
	public String getJEmployeesList(Model model) {
		List<Employee> employeeList = employeeService.getAll();
		model.addAttribute("employees", employeeList);
		return "hr/employees";
	}

	//View New Employee Form
	@GetMapping("/hr/employeeAdd")
	public String addEmployee(Model model){
		addModelAttributes(model);
		return "hr/employeeAdd";
	}


	//Save A new Employee
	@PostMapping("/hr/employees/save")
	public String save(Employee employee){
		employeeService.save(employee);
		return "redirect:/hr/employees";
	}


	//Update a Employee Record
	//View Update form
	@GetMapping("/hr/employeeEdit/{id}")
	public String editEmployee(@PathVariable Integer id, Model model){
		model.addAttribute("employee",employeeService.getById(id));
		addModelAttributes(model);
		return "hr/employeeEdit";
	}

	//View Details Page
	@GetMapping("/hr/employeeDetails/{id}")
	public String detailsEmployee(@PathVariable Integer id, Model model){
		model.addAttribute("employee",employeeService.getById(id));
		addModelAttributes(model);
		return "hr/employeeDetails";
	}


	//Save update
	@RequestMapping(value="/hr/employees/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
	public String update(Employee employee){
		employee.setEmployeeId(employee.getEmployeeId());
		employeeService.save(employee);
		return "redirect:/hr/employees";
	}

	//Delete A employee
	@RequestMapping(value="/hr/employees/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		employeeService.delete(id);
		return "redirect:/hr/employees";
	}
}
