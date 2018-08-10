package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    @Override
    public TimeEntry create(TimeEntry timeEntryToCreate) {
        Long id = timeEntries.size() + 1L;
        TimeEntry created = new TimeEntry(id,timeEntryToCreate.getProjectId(),timeEntryToCreate.getUserId(),timeEntryToCreate.getDate(),timeEntryToCreate.getHours());
        timeEntries.put(id, created);
        return created;
    }
    @Override
    public TimeEntry update(Long id, TimeEntry expected) {
        TimeEntry updated = new TimeEntry(id,expected.getProjectId(),expected.getUserId(),expected.getDate(),expected.getHours());
        timeEntries.replace(id,updated);
        return updated;
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry find(Long id) {
       return timeEntries.get(id);
    }


}
