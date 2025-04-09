package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
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
    public JournalEntry getJournalEntryById(@PathVariable Long journalId){

        return null;
    }

    @DeleteMapping("/id/{journalId}")
    public String deleteJournalEntryById(@PathVariable Long journalId){
        return "Deleted Successfully";
    }

    @PutMapping("/id/{journalId}")
    public JournalEntry updateJournalEntry(@PathVariable Long journalId, @RequestBody JournalEntry newEntry){
        return null;
    }

}
