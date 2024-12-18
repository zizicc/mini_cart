package com.yazi.minicart.service;

import com.yazi.minicart.dto.User;
import com.yazi.minicart.entities.UserEntity;
import com.yazi.minicart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserEntity> userDetail = repository.findByName(name); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + name));
    }

    public String addUser(UserEntity userInfo) {
        // Encode password before saving the user
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }
}
