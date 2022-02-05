package ga.linuxcafe.pms.security.services;

import ga.linuxcafe.pms.security.models.Users;
import ga.linuxcafe.pms.security.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public void save(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public Users getById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
}
