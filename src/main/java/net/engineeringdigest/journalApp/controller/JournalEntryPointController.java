package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryPointController {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping("/getEntries")
    public List<JournalEntry> allEntries(){
        return journalEntryService.getEntries();
    }

    @PostMapping("/addEntry")
    public String addEntry(@RequestBody JournalEntry entry){
        journalEntryService.saveEntry(entry);
        return "Successful";
    }

    @GetMapping("/id/{journalId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId journalId){
        return journalEntryService.getEntryById(journalId).orElse(null);
    }

    @DeleteMapping("/id/{journalId}")
    public String deleteJournalEntryById(@PathVariable ObjectId journalId){
        journalEntryService.deleteEntryById(journalId);
        return "Deleted Successfully";
    }

    @PutMapping("/id/{journalId}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId journalId, @RequestBody JournalEntry newEntry){
        JournalEntry oldEntry = journalEntryService.getEntryById(journalId).orElse(null);
        if(oldEntry!=null){
            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
        }
        journalEntryService.saveEntry(oldEntry);
        return null;
    }

}
