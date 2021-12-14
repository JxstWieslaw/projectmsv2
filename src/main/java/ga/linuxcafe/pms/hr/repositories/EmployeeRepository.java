package ga.linuxcafe.pms.hr.repositories;

import ga.linuxcafe.pms.hr.dto.EmployeeProject;
import ga.linuxcafe.pms.hr.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Override
	List<Employee>findAll();

	@Query(nativeQuery=true, value="SELECT e.firstname as firstName, e.lastname as lastName, COUNT(pe.employee_id) as projectCount " +
			"FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
			"GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
	List<EmployeeProject> employeeProjects();

    Employee findByUsername(String username);
}

