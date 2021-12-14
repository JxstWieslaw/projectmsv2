package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.PercentComplete;
import ga.linuxcafe.pms.parameters.repositories.PercentCompleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PercentCompleteService {

    @Autowired
    private PercentCompleteRepository percentCompleteRepository;

    public List<PercentComplete> getAll(){
        return percentCompleteRepository.findAll();
    }

    public void save(PercentComplete percentComplete){
        percentCompleteRepository.save(percentComplete);
    }

    public void delete(Integer id){
        percentCompleteRepository.deleteById(id);
    }
    
    public Optional<PercentComplete> getById(Integer id){
        return percentCompleteRepository.findById(id);
    }
}
