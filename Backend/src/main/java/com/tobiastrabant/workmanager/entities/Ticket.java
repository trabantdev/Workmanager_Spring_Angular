package com.tobiastrabant.workmanager.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "ticket")
public class Ticket extends Entry{
}
