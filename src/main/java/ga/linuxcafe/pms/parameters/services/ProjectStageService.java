package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.ProjectStage;
import ga.linuxcafe.pms.parameters.repositories.ProjectStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectStageService {

    @Autowired
    private ProjectStageRepository projectStageRepository;

    public List<ProjectStage> getAll(){
        return projectStageRepository.findAll();
    }

    public void save(ProjectStage projectStage){
        projectStageRepository.save(projectStage);
    }

    public void delete(Integer id){
        projectStageRepository.deleteById(id);
    }
    
    public Optional<ProjectStage> getById(Integer id){
        return projectStageRepository.findById(id);
    }
}
