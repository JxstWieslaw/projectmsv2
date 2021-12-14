package ga.linuxcafe.pms.hr.services;

import ga.linuxcafe.pms.hr.models.EmployeeStatus;
import ga.linuxcafe.pms.hr.repositories.EmployeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeStatusService {
	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;
	
	//Return list of EmployeeStatuses
	public List<EmployeeStatus> getAll(){
		return employeeStatusRepository.findAll();
	}
	
	//SAve new EmployeeStatus
	public void save(EmployeeStatus employeeStatus) {
		employeeStatusRepository.save(employeeStatus);
	}
	
	//get by id
	public Optional<EmployeeStatus> getById(int id) {
		return employeeStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeStatusRepository.deleteById(id);
	}

}
