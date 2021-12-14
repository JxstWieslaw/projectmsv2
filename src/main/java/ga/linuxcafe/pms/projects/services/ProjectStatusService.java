package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.models.ProjectStatus;
import ga.linuxcafe.pms.projects.repositores.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectStatusService {
	@Autowired
	private ProjectStatusRepository projectStatusRepository;
	
	//Return list of project Statuses
	public List<ProjectStatus> getAll(){
		return projectStatusRepository.findAll();
	}
	
	//SAve new ProjectStatus
	public void save(ProjectStatus projectStatus) {
		projectStatusRepository.save(projectStatus);
	}
	
	//get by id
	public Optional<ProjectStatus> getById(int id) {
		return projectStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		projectStatusRepository.deleteById(id);
	}


}
