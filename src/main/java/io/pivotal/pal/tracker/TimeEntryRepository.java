package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

@Repository
public class TimeEntryRepository {

    //private static List<TimeEntry> list = new ArrayList<>();
    private static Map<Long, TimeEntry> map = new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry timeEntry) {
        /*
        list.clear();
        timeEntry.setId(list.size() + 1);
        list.add(timeEntry);
        return timeEntry;
        */

        if (timeEntry.getId() == 0) {
            timeEntry.setId(System.currentTimeMillis());
        }
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(Long id) {
        //return list.get(list.size()-1);

        if (map.containsKey(id)) {
            return map.get(id);
        } else {
            return null;
        }
    }

    public List<TimeEntry> list() {
        //return list;

        return new ArrayList(map.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        //return new TimeEntry(2L, 3L, LocalDate.parse("2017-01-09"), 9);
        //return timeEntry;

        if (map.containsKey(id)) {
            TimeEntry entry = map.get(id);
            entry.setDate(timeEntry.getDate());
            entry.setHours(timeEntry.getHours());
            entry.setProjectId(timeEntry.getProjectId());
            entry.setUserId(timeEntry.getUserId());
            return entry;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }
    }

}
