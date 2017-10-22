package lv.tele2ssc.bookshelf;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Role findRole(String name) {
        return roleRepository.findByName(name);
    }
    
    public void save(User user) {
        Role usersRole = findRole("user");
        Set<Role> roleSet = Collections.singleton(usersRole);
        user.setRoles(roleSet);
        userRepository.save(user);
    }
}
