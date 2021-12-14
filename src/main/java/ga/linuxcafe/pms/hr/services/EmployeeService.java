package ga.linuxcafe.pms.hr.services;

import ga.linuxcafe.pms.hr.dto.EmployeeProject;
import ga.linuxcafe.pms.hr.models.Employee;
import ga.linuxcafe.pms.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}


	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}

	public Employee findByUsername(String username){
		return employeeRepository.findByUsername(username);
	}
	public Employee getById(Integer theId) {
		return employeeRepository.findById(theId).orElse(null);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
}