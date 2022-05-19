package com.tobiastrabant.workmanager.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @RequestMapping("/tickets")
    public String showTicketsList() {
        return "tickets-list";
    }

    @RequestMapping("/ticket-form")
    public String showTicketForm() {
        return "ticket-form";
    }

    @RequestMapping("/process-ticket-form")
    public String processTicketForm(@RequestParam(name="name") String name,
                                    @RequestParam(name="description") String description,
                                    @RequestParam(name="priority") String priority,
                                    Model model) {
        return "ticket-confirmation";
    }
}
