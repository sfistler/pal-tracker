package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

@Repository
public class TimeEntryRepository {

    @Autowired
    private InMemoryTimeEntryRepository inMemoryTimeEntryRepository;

    public TimeEntry create(TimeEntry timeEntry) {
        /*if (timeEntry.getId() == 0) {
            timeEntry.setId(System.currentTimeMillis());
        }
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;*/
        return inMemoryTimeEntryRepository.create(timeEntry);
    }

    public TimeEntry find(Long id) {
        /*if (map.containsKey(id)) {
            return map.get(id);
        } else {
            return null;
        }*/
       return inMemoryTimeEntryRepository.find(id);
    }

    public List<TimeEntry> list() {
        //return new ArrayList(map.values());
        return inMemoryTimeEntryRepository.list();
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        /*if (map.containsKey(id)) {
            TimeEntry entry = map.get(id);
            entry.setDate(timeEntry.getDate());
            entry.setHours(timeEntry.getHours());
            entry.setProjectId(timeEntry.getProjectId());
            entry.setUserId(timeEntry.getUserId());
            return entry;
        } else {
            return null;
        }*/
        return inMemoryTimeEntryRepository.update(id,timeEntry);
    }

    public void delete(Long id) {
        /*if (map.containsKey(id)) {
            map.remove(id);
        }*/
        inMemoryTimeEntryRepository.delete(id);
    }

}
