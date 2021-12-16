package com.sergioarboleda.cacharrero.app.repositories;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.crud.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * @author Carotobarj
 */

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    public User save(User usuario) {
        return repository.save(usuario);
    }

    public Optional<User> getUserByName(String name) {
        return repository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<User> getUsersByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name,email);
    }

    public Optional<User> getUserEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    /**
     *
     * @param id
     */
    public void deleteById (Integer id){
        repository.deleteById(id);
    }

}
