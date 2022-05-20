package com.tobiastrabant.workmanager.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Component
@Entity
public class Employee {

    public enum EmployeeRole
    {
        ADMIN("Admin"),
        MANAGER("Manager"),
        ENGINEER("Engineer"),
        UIUX("UI/UX"),
        QA("QA");

        private final String displayValue;

        private EmployeeRole(String displayValue) {
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
    private String firstName;
    @NotBlank
    private String lastName;
    private LocalDateTime creationTime;
    private EmployeeRole role;

    public void Test()
    {
        System.out.println("Test function");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }
}
