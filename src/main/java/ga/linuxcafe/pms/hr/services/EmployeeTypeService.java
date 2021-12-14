package ga.linuxcafe.pms.hr.services;

import ga.linuxcafe.pms.hr.models.EmployeeType;
import ga.linuxcafe.pms.hr.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeTypeService {
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//Return list of employeeTypes
	public List<EmployeeType> getAll(){
		return employeeTypeRepository.findAll();
	}
	
	//SAve new EmployeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	//get by id
	public Optional<EmployeeType> getById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}


}
