package ga.linuxcafe.pms.accounts.controllers;

import ga.linuxcafe.pms.accounts.models.Invoice;
import ga.linuxcafe.pms.accounts.services.InvoiceService;
import ga.linuxcafe.pms.accounts.services.InvoiceStatusService;
import ga.linuxcafe.pms.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceController {


	@Autowired	private InvoiceService invoiceService;
	@Autowired	private ClientService clientService;
	@Autowired	private InvoiceStatusService invoiceStatusService;


	@GetMapping("/accounts/invoices")
	public String getInvoices(Model model) {		
		model.addAttribute("invoices", invoiceService.getInvoices());
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getAll());
		return "accounts/invoice";
	}	
	
	@PostMapping("/accounts/invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/accounts/invoices";
	}
	
	@RequestMapping("/accounts/invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
	  return invoiceService.findById(id);	
	}	
	
	@RequestMapping(value="/accounts/invoices/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/accounts/invoices";
	}
	
	@RequestMapping(value="/accounts/invoices/delete/{id}", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		invoiceService.delete(id);
		return "redirect:/accounts/invoices";
	}
}
