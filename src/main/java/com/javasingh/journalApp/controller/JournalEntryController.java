package com.javasingh.journalApp.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javasingh.journalApp.Entity.JournalEntry;
import com.javasingh.journalApp.Entity.User;
import com.javasingh.journalApp.Services.JournalEntryServices;
import com.javasingh.journalApp.Services.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryServices journalEntryService;

    @Autowired
    private UserService userService;


    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry>all = user.getJournalEntries(); 
        if(all !=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName){
        try {
            
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById (@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry =  journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
            return new  ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?>  deleteJournalEntryById (@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // @PutMapping("id/{id}")
    // public ResponseEntity<?> updateJournalEntryById (@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
    //     JournalEntry  oldEntry = journalEntryService.findById(id).orElse(null);
    //     if (oldEntry != null){
    //         oldEntry.setTitle(newEntry.getTitle()!=null&&! newEntry.getTitle().equals("")?newEntry.getTitle():oldEntry.getTitle());
    //         oldEntry.setContent(newEntry.getContent()!=null&&! newEntry.getContent().equals("")?newEntry.getContent():oldEntry.getContent());
    //         journalEntryService.saveEntry(oldEntry);
    //         return new ResponseEntity<>(oldEntry, HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>(oldEntry, HttpStatus.NOT_FOUND);
        
    // }
}
