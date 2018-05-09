/*import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

i*mport io.pivotal.pal.tracker.TimeEntryRepository;
        /package io.pivotal.pal.tracker;

public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
    }
    public ResponseEntity create(TimeEntry timeEntry){

        return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);
    }
    public ResponseEntity read(long l){

        return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);
    }
    public ResponseEntity list(){

        return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);
    }

    public ResponseEntity update(long l, TimeEntry timeEntry){

        return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);
    }

    public ResponseEntity delete(long l){

        return new ResponseEntity<String>("Hello World",  HttpStatus.CREATED);
    }
}*/
package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntriesRepo;

    public TimeEntryController(TimeEntryRepository timeEntriesRepo) {
        this.timeEntriesRepo = timeEntriesRepo;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntry);

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntriesRepo.find(id);
        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntriesRepo.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = timeEntriesRepo.update(id, timeEntry);
        if (updatedTimeEntry != null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
        timeEntriesRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

