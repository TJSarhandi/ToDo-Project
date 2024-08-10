package com.taimur.ToDo.Impl;

import com.taimur.ToDo.Entity.User;
import com.taimur.ToDo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);
        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
                .password(user.getPassword()).build();
    }

    public void registerUser(User user) {
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
