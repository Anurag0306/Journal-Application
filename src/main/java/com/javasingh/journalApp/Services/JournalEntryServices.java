package com.javasingh.journalApp.Services;

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

}
// controller  ----> Service ------> repository