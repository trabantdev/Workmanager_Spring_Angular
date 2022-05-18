package com.tobiastrabant.workmanager.entities;

import java.util.Date;

public class Entry {

    public enum EntryPriority
    {
        LOW,
        MEDIUM,
        HIGH
    }

    private String entryName;
    private String description;
    private EntryPriority priority;
    private User creator;
    private Date creationTime;
    private Date lastUpdated;
    private User[] assignedEmployees;

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntryPriority getPriority() {
        return priority;
    }

    public void setPriority(EntryPriority priority) {
        this.priority = priority;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User[] getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(User[] assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }
}
