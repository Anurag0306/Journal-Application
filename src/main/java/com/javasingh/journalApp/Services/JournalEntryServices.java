package com.javasingh.journalApp.Services;

import java.util.List;

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

}
// controller  ----> Service ------> repository