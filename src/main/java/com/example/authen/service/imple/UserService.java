package com.example.authen.service.imple;

import com.example.authen.entities.User;
import com.example.authen.entities.UserImpl;
import com.example.authen.repository.UserRepository;
import com.example.authen.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService implements Service, UserDetailsService {


    @Autowired
    private UserRepository  repo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public String createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    repo.save(user);
        return "USER CREATED SUCCESSFUL";
    }

    @Override
    public String updateUser(User user) {
     final    User update = repo.save(user);
        return "UPDATE USER SUCCESSFUL";
    }

    @Override
    public Optional<User> getUserById(Long id) {
     final    Optional <User> getById = repo.findById(id);
        return getById;
    }

    @Override
    public void deleteUserById(Long id) {
    repo.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
     final    List<User> getAllUsers = repo.findAll();
        return getAllUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Optional <User> user = repo.findUserByUsername(username);

      return user.map(UserImpl::new).orElseThrow(()-> new UsernameNotFoundException("Username not found"));




    }
}
