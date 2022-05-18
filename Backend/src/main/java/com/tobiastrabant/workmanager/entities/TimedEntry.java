package com.tobiastrabant.workmanager.entities;

import java.util.Date;

public class TimedEntry extends Entry{

    // A TimedEntry is an Entry with an associated deadline

    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
