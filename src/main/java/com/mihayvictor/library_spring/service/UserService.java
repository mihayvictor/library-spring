package com.mihayvictor.library_spring.service;

import com.mihayvictor.library_spring.model.entities.User;
import com.mihayvictor.library_spring.repository.UserRepository;
import com.mihayvictor.library_spring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        Optional<User> obj = Optional.ofNullable(repository.findById(id))
                .orElseThrow(() -> new ObjectNotFoundException("ID não encntrado."));
        return obj.get();
    }

    public List<User>findAll(){
        return repository.findAll();
    }

    public User insert(User user){
        return repository.save(user);
    }
}
