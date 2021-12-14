package ga.linuxcafe.pms.helpdesk.controllers;

import ga.linuxcafe.pms.helpdesk.models.Ticket;
import ga.linuxcafe.pms.helpdesk.services.TicketService;
import ga.linuxcafe.pms.helpdesk.services.TicketStatusService;
import ga.linuxcafe.pms.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketStatusService ticketStatusService;

    //View Ticket List form.
    @GetMapping("/helpdesk/tickets")
    public String getTicketsList(Model model){
        model.addAttribute("tickets",ticketService.getAll());
        return "helpdesk/tickets";
    }

    //View New Ticket Form
    @GetMapping("/helpdesk/ticketAdd")
    public String addTicket(Model model){
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("ticketStatuses",ticketStatusService.getAll());
        return "helpdesk/ticketAdd";
    }
    //Save A new Ticket
    @PostMapping("/helpdesk/tickets/save")
    public String save(Ticket ticket){
        ticketService.save(ticket);
        return "redirect:/helpdesk/tickets";
    }


    //Update a Ticket Record
    //View Update form
    @GetMapping("/helpdesk/ticketEdit/{id}")
    public String editTicket(@PathVariable Integer id, Model model){
        model.addAttribute("ticket",ticketService.getById(id));
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("ticketStatuses",ticketStatusService.getAll());
        return "helpdesk/ticketEdit";
    }

    //View Details Page
    @GetMapping("/helpdesk/ticketDetails/{id}")
    public String detailsTicket(@PathVariable Integer id, Model model){
        model.addAttribute("ticket",ticketService.getById(id));
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("ticketStatuses",ticketStatusService.getAll());
        return "helpdesk/ticketDetails";
    }


    //Save update
    @RequestMapping(value="/helpdesk/tickets/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Ticket ticket){
        ticketService.save(ticket);
        return "redirect:/helpdesk/tickets";
    }

    //Delete A ticket
    @RequestMapping(value="/helpdesk/tickets/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        ticketService.delete(id);
        return "redirect:/helpdesk/tickets";
    }
}
