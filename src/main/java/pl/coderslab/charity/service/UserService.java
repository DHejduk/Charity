package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.dto.UserDto;
import pl.coderslab.charity.model.entity.Role;
import pl.coderslab.charity.model.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.security.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Service @Transactional
@RequiredArgsConstructor
public class UserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleServiceImpl roleService;
    private final PasswordEncoder passwordEncoder;


    public void save(User user) {
        userRepository.save(user);
    }


    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    public boolean userExists(String email){
        User byEmail = userRepository.findByEmail(email);
        return byEmail == null;
    }

    public String encodePassword(String password) {
        return passwordEncoder.encoder().encode(password);
    }

    public boolean passwordMatches( String given,String encoded){
        return passwordEncoder.encoder().matches(given, encoded);
    }

    public void createUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encoder().encode(userDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findRoleByName("USER"));
        user.setRoles(roles);
        this.save(user);
    }

    public User getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return  this.findByEmail(username);
    }
}
