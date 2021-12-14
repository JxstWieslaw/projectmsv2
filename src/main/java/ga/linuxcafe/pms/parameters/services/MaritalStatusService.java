package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.MaritalStatus;
import ga.linuxcafe.pms.parameters.repositories.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaritalStatusService {

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    public List<MaritalStatus> getAll(){
        return maritalStatusRepository.findAll();
    }

    public void save(MaritalStatus maritalStatus){
        maritalStatusRepository.save(maritalStatus);
    }

    public void delete(Integer id){
        maritalStatusRepository.deleteById(id);
    }
    
    public Optional<MaritalStatus> getById(Integer id){
        return maritalStatusRepository.findById(id);
    }
}
