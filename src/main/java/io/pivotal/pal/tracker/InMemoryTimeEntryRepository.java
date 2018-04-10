package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository {

    private Map<Long, TimeEntry> map = new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(map.size() + 1);
        map.put(timeEntry.getId(), timeEntry);
        /*if (timeEntry.getId() == 0) {
            timeEntry.setId(System.currentTimeMillis());
        }
        map.put(timeEntry.getId(), timeEntry);*/
        return timeEntry;
    }

    public TimeEntry find(Long id) {
        return map.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(map.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {

        timeEntry.setId(id);
        map.replace(id, timeEntry);
        return timeEntry;
    }

    public void delete(Long id) {
        map.remove(id);
    }

}
