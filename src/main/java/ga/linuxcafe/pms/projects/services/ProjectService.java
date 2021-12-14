package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.dto.ProjectProjectStatus;
import ga.linuxcafe.pms.projects.models.Project;
import ga.linuxcafe.pms.projects.repositores.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	//Return list of projects
	public List<Project> getAll(){
		return projectRepository.findAll();
	}

	public List<ProjectProjectStatus> projectProjectStatus(){
		return projectRepository.projectProjectStatus();
	}

	
	//SAve new Project
	public void save(Project project) {
		projectRepository.save(project);
	}
	
	//get by id
	public Project getById(int id) {
		return projectRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		projectRepository.deleteById(id);
	}


}
