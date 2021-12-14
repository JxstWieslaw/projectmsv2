package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.ProjectPriority;
import ga.linuxcafe.pms.parameters.repositories.ProjectPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectPriorityService {

    @Autowired
    private ProjectPriorityRepository projectPriorityRepository;

    public List<ProjectPriority> getAll(){
        return projectPriorityRepository.findAll();
    }

    public void save(ProjectPriority title){
        projectPriorityRepository.save(title);
    }

    public void delete(Integer id){
        projectPriorityRepository.deleteById(id);
    }
    
    public Optional<ProjectPriority> getById(Integer id){
        return projectPriorityRepository.findById(id);
    }
}
