package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.Module;
import ga.linuxcafe.pms.parameters.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> getAll(){
        return moduleRepository.findAll();
    }

    public void save(Module module){
        moduleRepository.save(module);
    }

    public void delete(Integer id){
        moduleRepository.deleteById(id);
    }
    
    public Optional<Module> getById(Integer id){
        return moduleRepository.findById(id);
    }
}
