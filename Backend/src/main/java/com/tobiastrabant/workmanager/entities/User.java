package com.tobiastrabant.workmanager.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Component
@Entity
public class User {

    public enum UserRole
    {
        ADMIN,
        MANAGER,
        ENGINEER,
        UIUX,
        QA
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Date creationTime;
    private UserRole role;

    public void Test()
    {
        System.out.println("Test function");
    }
}
