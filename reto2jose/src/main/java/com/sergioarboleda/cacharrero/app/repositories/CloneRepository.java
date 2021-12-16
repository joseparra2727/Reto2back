package com.sergioarboleda.cacharrero.app.repositories;

import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repositories.crud.CloneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author Carotobarj
 */

@Repository
public class CloneRepository {

    @Autowired
    private CloneCrudRepository repository;

    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getCloneById(Integer id){
        return repository.findById(id);
    }

    public Clone save(Clone clon) {
        return repository.save(clon);
    }

    /**
     *
     * @param id
     */
    public void deleteById (Integer id){
        repository.deleteById(id);
    }
}
