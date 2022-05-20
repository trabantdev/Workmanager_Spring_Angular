package com.tobiastrabant.workmanager.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@MappedSuperclass
public abstract class Entry {

    public enum EntryPriority
    {
        LOW("Low"),
        MEDIUM("Medium"),
        HIGH("High");

        private final String displayValue;

        private EntryPriority(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private EntryPriority priority;
    //private User creator;
    private Date creationTime;
    private Date lastUpdated;
    //private User[] assignedEmployees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

/*    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }*/

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

/*    public User[] getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(User[] assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }*/
}
