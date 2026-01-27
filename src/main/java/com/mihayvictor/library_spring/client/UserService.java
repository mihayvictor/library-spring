package com.mihayvictor.library_spring.client;

import com.mihayvictor.library_spring.client.entity.User;
import com.mihayvictor.library_spring.exception.serviceException.DatabaseException;
import com.mihayvictor.library_spring.exception.serviceException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        Optional<User> obj = Optional.of(repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário de ID " + id + " não encontrado.")));
        return obj.get();
    }

    public List<User>findAll(){
        return repository.findAll();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            User user = repository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Usuário de ID " + id + " não encontrado."));
            repository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade - você não pode deletar um usuário que possui empréstimos" +
                    "associados a ele.");
        }
    }

}
