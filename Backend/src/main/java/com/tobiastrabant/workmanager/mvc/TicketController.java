package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Ticket;
import com.tobiastrabant.workmanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/list")
    public String showTicketsList(Model model) {
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets-list";
    }

    @GetMapping("/add")
    public String showTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/addOrUpdate")
    public String processAddTicketForm(@Valid @ModelAttribute("ticket") Ticket ticket,
                                         BindingResult bindingResult,
                                         Model model) {
        model.addAttribute("ticket", ticket);
        if (bindingResult.hasErrors()) {
            return "ticket-form";
        } else {
            ticketService.save(ticket);
            return "redirect:/tickets/list";
        }
    }

    @GetMapping("/update")
    public String showUpdateTicketForm(@RequestParam("ticketID") int id, Model model) {
        model.addAttribute("ticket", ticketService.findById(id));
        return "ticket-form";
    }

    @GetMapping("/delete")
    public String deleteTicket(@RequestParam("ticketID") int id) {
        ticketService.deleteById(id);
        return "redirect:/tickets/list";
    }
}
