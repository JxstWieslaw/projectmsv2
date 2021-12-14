package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.Gender;
import ga.linuxcafe.pms.parameters.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> getAll(){
        return genderRepository.findAll();
    }

    public void save(Gender gender){
        genderRepository.save(gender);
    }

    public void delete(Integer id){
        genderRepository.deleteById(id);
    }
    
    public Optional<Gender> getById(Integer id){
        return genderRepository.findById(id);
    }
}
