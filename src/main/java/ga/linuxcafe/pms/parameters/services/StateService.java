package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.State;
import ga.linuxcafe.pms.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll(){
        return stateRepository.findAll();
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public void delete(Integer id){
        stateRepository.deleteById(id);
    }
    
    public State getById(Integer id){
        return stateRepository.findById(id).orElse(null);
    }
}
