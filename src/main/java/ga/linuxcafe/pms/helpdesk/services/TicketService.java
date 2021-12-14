package ga.linuxcafe.pms.helpdesk.services;

import ga.linuxcafe.pms.helpdesk.models.Ticket;
import ga.linuxcafe.pms.helpdesk.repositores.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public void save(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void delete(Integer id){
        ticketRepository.deleteById(id);
    }
    
    public Ticket getById(Integer id){
        return ticketRepository.findById(id).orElse(null);
    }
}
