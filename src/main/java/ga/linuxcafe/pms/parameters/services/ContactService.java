package ga.linuxcafe.pms.parameters.services;

import ga.linuxcafe.pms.parameters.models.Contact;
import ga.linuxcafe.pms.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    public void save(Contact contact){
        contactRepository.save(contact);
    }

    public void delete(Integer id){
        contactRepository.deleteById(id);
    }
    
    public Optional<Contact> getById(Integer id){
        return contactRepository.findById(id);
    }
}
