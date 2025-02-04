package com.javasingh.journalApp.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javasingh.journalApp.Entity.JournalEntry;
import com.javasingh.journalApp.Repository.JournalEntryRepo;

@Component
public class JournalEntryServices {

    @Autowired
    private JournalEntryRepo journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

}
// controller  ----> Service ------> repository