package ga.linuxcafe.pms.security.services;

import ga.linuxcafe.pms.security.models.Role;
import ga.linuxcafe.pms.security.models.Users;
import ga.linuxcafe.pms.security.repositores.RoleRepository;
import ga.linuxcafe.pms.security.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public void save(Role roles){
        roleRepository.save(roles);
    }

    public void delete(Integer id){
        roleRepository.deleteById(id);
    }
    
    public Role getById(Integer id){
        return roleRepository.findById(id).orElse(null);
    }

    //Assign Role to User
    public void assignUserRole(Integer userId, Integer roleId){
        Users user  = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    //Unassign Role to User
    public void unassignUserRole(Integer userId, Integer roleId){
        Users user  = userRepository.findById(userId).orElse(null);
        user.getRoles().removeIf(x -> x.getId()==roleId);
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(Users user){
        return user.getRoles();
    }

    public Set<Role> getUserNotRoles(Users user){
        return roleRepository.getUserNotRoles(user.getId());
    }

}
