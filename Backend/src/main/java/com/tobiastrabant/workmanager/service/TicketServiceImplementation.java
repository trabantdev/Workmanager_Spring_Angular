package com.tobiastrabant.workmanager.service;

import com.tobiastrabant.workmanager.dao.TicketRepository;
import com.tobiastrabant.workmanager.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImplementation implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImplementation(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findById(int id) {
        Optional<Ticket> result = ticketRepository.findById(id);

        if (result.isPresent()) {
            Ticket ticket = result.get();
            return ticket;
        }
        else {
            throw new RuntimeException("Could not find employee with id - " + id);
        }
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }
}
