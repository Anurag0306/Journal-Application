package com.javasingh.journalApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javasingh.journalApp.Entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String> {

}
