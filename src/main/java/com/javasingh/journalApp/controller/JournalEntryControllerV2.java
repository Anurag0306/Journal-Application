package com.javasingh.journalApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javasingh.journalApp.Entity.JournalEntry;
import com.javasingh.journalApp.Services.JournalEntryServices;

import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryServices journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById (@PathVariable Long myId){
        return null;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry removeJournalEntryById (@PathVariable Long myId){
        return null;
    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById (@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return null;
        
    }
}
