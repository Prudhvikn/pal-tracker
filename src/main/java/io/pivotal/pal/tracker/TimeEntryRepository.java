package io.pivotal.pal.tracker;




import java.util.List;

public interface TimeEntryRepository {

    TimeEntry update(Long id, TimeEntry expected);

    void delete(Long id);

    List<TimeEntry> list();

    TimeEntry find(Long id);

    TimeEntry create(TimeEntry timeEntryToCreate);
}
