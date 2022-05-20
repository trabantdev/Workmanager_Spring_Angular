package com.tobiastrabant.workmanager.entities;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class TimedEntry extends Entry{

    // A TimedEntry is an Entry with an associated deadline

    private LocalDateTime deadline;

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
