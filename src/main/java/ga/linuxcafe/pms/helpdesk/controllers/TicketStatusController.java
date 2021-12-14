package ga.linuxcafe.pms.helpdesk.controllers;

import ga.linuxcafe.pms.helpdesk.models.TicketStatus;
import ga.linuxcafe.pms.helpdesk.services.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TicketStatusController {

	@Autowired  private TicketStatusService ticketStatusService;

	@GetMapping("/helpdesk/ticketStatuses")
	public String getTicketStatuses(Model model) {
		List<TicketStatus> ticketStatusList = ticketStatusService.getAll();
		model.addAttribute("ticketStatuses", ticketStatusList);
		return "helpdesk/ticketStatus";
	}

	@PostMapping("/helpdesk/ticketStatuses/addNew")
	public String addNew(TicketStatus ticketStatus) {
		ticketStatusService.save(ticketStatus);
		return "redirect:/helpdesk/ticketStatuses";
	}

	@RequestMapping("/helpdesk/ticketStatuses/findById")
	@ResponseBody
	public Optional<TicketStatus> findById(int id) {
		return ticketStatusService.getById(id);
	}

	@RequestMapping(value="/helpdesk/ticketStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(TicketStatus ticketStatus) {
		ticketStatusService.save(ticketStatus);
		return "redirect:/helpdesk/ticketStatuses";
	}

	@RequestMapping(value="/helpdesk/ticketStatuses/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		ticketStatusService.delete(id);
		return "redirect:/helpdesk/ticketStatuses";
	}
}
