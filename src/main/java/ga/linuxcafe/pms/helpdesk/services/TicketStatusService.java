package ga.linuxcafe.pms.helpdesk.services;

import ga.linuxcafe.pms.helpdesk.models.TicketStatus;
import ga.linuxcafe.pms.helpdesk.repositores.TicketStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketStatusService {
	@Autowired
	private TicketStatusRepository ticketStatusRepository;
	
	//Return list of countries
	public List<TicketStatus> getAll(){
		return ticketStatusRepository.findAll();
	}
	
	//SAve new TicketStatus
	public void save(TicketStatus ticketStatus) {
		ticketStatusRepository.save(ticketStatus);
	}
	
	//get by id
	public Optional<TicketStatus> getById(int id) {
		return ticketStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		ticketStatusRepository.deleteById(id);
	}

}
