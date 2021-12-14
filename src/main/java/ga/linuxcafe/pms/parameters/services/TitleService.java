package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.Title;
import ga.linuxcafe.pms.parameters.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> getAll(){
        return titleRepository.findAll();
    }

    public void save(Title title){
        titleRepository.save(title);
    }

    public void delete(Integer id){
        titleRepository.deleteById(id);
    }
    
    public Optional<Title> getById(Integer id){
        return titleRepository.findById(id);
    }
}
