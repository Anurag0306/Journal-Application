package com.javasingh.journalApp.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javasingh.journalApp.Entity.User;
import com.javasingh.journalApp.Repository.UserRepo;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user) {
        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }
    public User findByUserName (String userName){
        return userRepo.findByUserName(userName);
    }


}
// controller  ----> Service ------> repository