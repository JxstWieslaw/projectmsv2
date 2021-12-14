package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.models.ProjectPersonnel;
import ga.linuxcafe.pms.projects.repositores.ProjectPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjecPersonnelService {
	@Autowired
	private ProjectPersonnelRepository projectPersonnelRepository;
	
	//Return list of project Personnel
	public List<ProjectPersonnel> getAll(){
		return projectPersonnelRepository.findAll();
	}
	
	//SAve new ProjectPersonnel
	public void save(ProjectPersonnel projectPersonnel) {
		projectPersonnelRepository.save(projectPersonnel);
	}
	
	//get by id
	public Optional<ProjectPersonnel> getById(int id) {
		return projectPersonnelRepository.findById(id);
	}

	public void delete(Integer id) {
		projectPersonnelRepository.deleteById(id);
	}


}
