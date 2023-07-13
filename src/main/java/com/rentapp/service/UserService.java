package com.rentapp.service;

import com.rentapp.api.dto.CreateUserCommand;
import com.rentapp.domain.entity.User;
import com.rentapp.exception.ElementNotFoundException;
import com.rentapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(CreateUserCommand createUserCommand){
        User user = User.builder()
                .login(createUserCommand.getLogin())
                .password(createUserCommand.getPassword())
                .email(createUserCommand.getEmail())
                .build();
        //userRepository nadaje id?
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User get(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException());
    }

}
