package com.sergioarboleda.cacharrero.app.controllers;


import com.sergioarboleda.cacharrero.app.model.User;
import java.util.List;

import com.sergioarboleda.cacharrero.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carotobarj
 */

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserServices service;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

    /**
     *
     * @param usuario
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usuario){
        return service.save(usuario);
    }

    /**
     *
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User existsUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailPass(email, password);
    }

    /**
     *
     * @param usuario
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User usuario){
        return service.update(usuario);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }
}
