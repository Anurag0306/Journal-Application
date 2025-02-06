package com.javasingh.journalApp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.javasingh.journalApp.Entity.User;

public interface UserRepo extends MongoRepository<User,ObjectId> {
    User findByUserName(String username);
    
} 