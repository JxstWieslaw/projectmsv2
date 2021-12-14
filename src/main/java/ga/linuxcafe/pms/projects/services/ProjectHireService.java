package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.models.ProjectHire;
import ga.linuxcafe.pms.projects.repositores.ProjectHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectHireService {
	@Autowired
	private ProjectHireRepository projectHireRepository;
	
	//Return list of project Hires
	public List<ProjectHire> getAll(){
		return projectHireRepository.findAll();
	}
	
	//SAve new ProjectHire
	public void save(ProjectHire projectHire) {
		projectHireRepository.save(projectHire);
	}
	
	//get by id
	public ProjectHire getById(int id) {
		return projectHireRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		projectHireRepository.deleteById(id);
	}


}
