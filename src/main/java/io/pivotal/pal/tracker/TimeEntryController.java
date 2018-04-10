package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping(value = "/time-entries", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        final TimeEntry entry = timeEntryRepository.find(id);
        HttpStatus status = HttpStatus.OK;
        if (entry == null) {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity(entry, status);
    }

    @GetMapping("/time-entries")
    @ResponseBody
    public ResponseEntity<List<TimeEntry>> list(){
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    @PutMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        //return ResponseEntity.ok(timeEntryRepository.update(id, timeEntry));

        if (timeEntry.getProjectId() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(timeEntryRepository.update(id, timeEntry), HttpStatus.OK);
        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
