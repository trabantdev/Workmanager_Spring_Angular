package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.entities.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    Ticket findById(int id);

    void save(Ticket ticket);

    void deleteById(int id);
}
