package com.taimur.ToDo.User.Impl;

import com.taimur.ToDo.User.MyUser;
import com.taimur.ToDo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

  
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = repository.findByUsername(username).get();

        return User.builder().username(myUser.getUsername()).password(myUser.getPassword()).build();

    }


    public void registerUser(MyUser myuser) {
        if (myuser == null) {
            throw new RuntimeException("invalid user name password");
        }
        myuser.setPassword(passwordEncoder.encode(myuser.getPassword()));
        repository.save(myuser);
    }
}
