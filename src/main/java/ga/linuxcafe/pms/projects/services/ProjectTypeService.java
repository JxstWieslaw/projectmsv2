package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.models.ProjectType;
import ga.linuxcafe.pms.projects.repositores.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeService {
	@Autowired
	private ProjectTypeRepository projectTypeRepository;
	
	//Return list of project Types
	public List<ProjectType> getAll(){
		return projectTypeRepository.findAll();
	}
	
	//SAve new ProjectType
	public void save(ProjectType projectType) {
		projectTypeRepository.save(projectType);
	}
	
	//get by id
	public Optional<ProjectType> getById(int id) {
		return projectTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		projectTypeRepository.deleteById(id);
	}


}
