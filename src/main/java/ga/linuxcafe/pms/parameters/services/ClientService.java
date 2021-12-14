package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.Client;
import ga.linuxcafe.pms.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
    
    public Client getById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }
}
