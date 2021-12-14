package ga.linuxcafe.pms.accounts.controllers;

import ga.linuxcafe.pms.accounts.models.InvoiceStatus;
import ga.linuxcafe.pms.accounts.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

	@Autowired  private InvoiceStatusService invoiceStatusService;

	@GetMapping("/accounts/invoiceStatuses")
	public String getInvoiceStatuss(Model model) {
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getAll();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		return "accounts/invoiceStatus";
	}

	@PostMapping("/accounts/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/accounts/invoiceStatuses";
	}

	@RequestMapping("/accounts/invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.getById(id);
	}

	@RequestMapping(value="/accounts/invoiceStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/accounts/invoiceStatuses";
	}

	@RequestMapping(value="/accounts/invoiceStatuses/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		invoiceStatusService.delete(id);
		return "redirect:/accounts/invoiceStatuses";
	}
}
