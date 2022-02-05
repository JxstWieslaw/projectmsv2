//package ga.linuxcafe.pms.parameters.services;
//
//import ga.linuxcafe.pms.parameters.models.UserPrincipal;
//import ga.linuxcafe.pms.security.models.Users;
//import ga.linuxcafe.pms.security.repositores.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(username);
//
//        if(user == null){
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return new UserPrincipal(user);
//    }
//}
