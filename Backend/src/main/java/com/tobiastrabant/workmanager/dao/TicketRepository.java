package com.tobiastrabant.workmanager.dao;

import com.tobiastrabant.workmanager.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
