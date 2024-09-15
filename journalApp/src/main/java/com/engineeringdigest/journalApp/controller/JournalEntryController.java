package com.engineeringdigest.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringdigest.journalApp.entity.JournalEntry;

@RestController
public class JournalEntryController {

	private Map<Long,JournalEntry> journalEntries= new HashMap<>();
	
	@GetMapping
	public List<JournalEntry> getAll(){
		
		return new ArrayList<>(journalEntries.values());
		
	}
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		
		journalEntries.put(myEntry.getId(), myEntry);
		return true;
	}
	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable Long myId) {
		
		return journalEntries.get(myId);
	}
	@DeleteMapping("id/{myid}")
	public JournalEntry deleteJournalEntryById(@PathVariable Long myid) {
		return journalEntries.remove(myid);
	}
	
	@PutMapping("id/{id}")
	public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
		
		return journalEntries.put(id, myEntry);
	}
	
}
