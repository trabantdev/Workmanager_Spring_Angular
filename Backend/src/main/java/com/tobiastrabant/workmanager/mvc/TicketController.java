package com.tobiastrabant.workmanager.mvc;

import com.tobiastrabant.workmanager.entities.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @GetMapping("/list")
    public String showTicketsList() {
        return "tickets-list";
    }

    @GetMapping("/form")
    public String showTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/form")
    public String processTicketForm(@ModelAttribute Ticket ticket,
                                    Model model) {
        model.addAttribute("ticket", ticket);
        return "ticket-confirmation";
    }
}
