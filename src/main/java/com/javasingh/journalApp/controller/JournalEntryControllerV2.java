package com.javasingh.journalApp.controller;
import org.bson.types.ObjectId;
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

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryServices journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById (@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }
    @DeleteMapping("id/{myId}")
    public boolean  removeJournalEntryById (@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById (@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry  oldEntry = journalEntryService.findById(id).orElse(null);
        if (oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle()!=null&&! newEntry.getTitle().equals("")?newEntry.getTitle():oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent()!=null&&! newEntry.getContent().equals("")?newEntry.getContent():oldEntry.getContent());

        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
        
    }
}
