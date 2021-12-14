package ga.linuxcafe.pms.accounts.controllers;

import ga.linuxcafe.pms.accounts.models.TransactionType;
import ga.linuxcafe.pms.accounts.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TransactionTypeController {

	@Autowired  private TransactionTypeService transactionTypeService;

	@GetMapping("/accounts/transactionTypes")
	public String getTransactionTypes(Model model) {
		List<TransactionType> transactionTypeList = transactionTypeService.getAll();
		model.addAttribute("transactionTypes", transactionTypeList);
		return "accounts/transactionType";
	}

	@PostMapping("/accounts/transactionTypes/addNew")
	public String addNew(TransactionType transactionType) {
		transactionTypeService.save(transactionType);
		return "redirect:/accounts/transactionTypes";
	}

	@RequestMapping("/accounts/transactionTypes/findById")
	@ResponseBody
	public Optional<TransactionType> findById(int id) {
		return transactionTypeService.getById(id);
	}

	@RequestMapping(value="/accounts/transactionTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(TransactionType transactionType) {
		transactionTypeService.save(transactionType);
		return "redirect:/accounts/transactionTypes";
	}

	@RequestMapping(value="/accounts/transactionTypes/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable Integer id){
		transactionTypeService.delete(id);
		return "redirect:/accounts/transactionTypes";
	}
}
