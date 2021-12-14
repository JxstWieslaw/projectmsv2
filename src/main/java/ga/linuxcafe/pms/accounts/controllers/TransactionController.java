package ga.linuxcafe.pms.accounts.controllers;

import ga.linuxcafe.pms.accounts.models.Transaction;
import ga.linuxcafe.pms.accounts.services.TransactionService;
import ga.linuxcafe.pms.accounts.services.TransactionStatusService;
import ga.linuxcafe.pms.accounts.services.TransactionTypeService;
import ga.linuxcafe.pms.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionTypeService transactionTypeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TransactionStatusService transactionStatusService;

    //View Transaction List form.
    @GetMapping("/accounts/transactions")
    public String getTransactionsList(Model model){
        model.addAttribute("transactions",transactionService.getAll());
        return "accounts/transaction";
    }

    //View New Transaction Form
    @GetMapping("/accounts/transactionAdd")
    public String addTransaction(Model model){
        model.addAttribute("transactionTypes", transactionTypeService.getAll());
        model.addAttribute("employees",employeeService.getAll());
        model.addAttribute("transactionStatuses",transactionStatusService.getAll());
        return "accounts/transactionAdd";
    }

    //Save A new Transaction
    @PostMapping("/accounts/transactions/save")
    public String save(Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/accounts/transactions";
    }


    //Update a Transaction Record
    //View Update form
    @GetMapping("/accounts/transactionEdit/{id}")
    public String editTransaction(@PathVariable Integer id, Model model){
        model.addAttribute("transaction",transactionService.getById(id));
        model.addAttribute("transactionTypes", transactionTypeService.getAll());
        model.addAttribute("employees",employeeService.getAll());
        model.addAttribute("transactionStatuses",transactionStatusService.getAll());
        return "accounts/transactionEdit";
    }

    //View Details Page
    @GetMapping("/accounts/transactionDetails/{id}")
    public String detailsTransaction(@PathVariable Integer id, Model model){
        model.addAttribute("transaction",transactionService.getById(id));
        model.addAttribute("transactionTypes", transactionTypeService.getAll());
        model.addAttribute("employees",employeeService.getAll());
        model.addAttribute("transactionStatuses",transactionStatusService.getAll());
        return "accounts/transactionDetails";
    }


    //Save update
    @RequestMapping(value="/accounts/transactions/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/accounts/transactions";
    }

    //Delete A transaction
    @RequestMapping(value="/accounts/transactions/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        transactionService.delete(id);
        return "redirect:/accounts/transactions";
    }
}
