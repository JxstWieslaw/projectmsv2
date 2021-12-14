package ga.linuxcafe.pms.projects.services;

import ga.linuxcafe.pms.projects.models.ProjectMaintenance;
import ga.linuxcafe.pms.projects.repositores.ProjectMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMaintenanceService {
	@Autowired
	private ProjectMaintenanceRepository projectMaintenanceRepository;
	
	//Return list of project Maintenances
	public List<ProjectMaintenance> getAll(){
		return projectMaintenanceRepository.findAll();
	}
	
	//SAve new ProjectMaintenance
	public void save(ProjectMaintenance projectMaintenance) {
		projectMaintenanceRepository.save(projectMaintenance);
	}
	
	//get by id
	public ProjectMaintenance getById(int id) {
		return projectMaintenanceRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		projectMaintenanceRepository.deleteById(id);
	}


}
