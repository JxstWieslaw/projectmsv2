package ga.linuxcafe.pms.hr.services;

import ga.linuxcafe.pms.hr.models.JobRole;
import ga.linuxcafe.pms.hr.repositories.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobRoleService {
	@Autowired
	private JobRoleRepository jobRoleRepository;
	
	//Return list of job Roles
	public List<JobRole> getAll(){
		return jobRoleRepository.findAll();
	}
	
	//SAve new JobRole
	public void save(JobRole jobRole) {
		jobRoleRepository.save(jobRole);
	}
	
	//get by id
	public Optional<JobRole> getById(int id) {
		return jobRoleRepository.findById(id);
	}

	public void delete(Integer id) {
		jobRoleRepository.deleteById(id);
	}

}
