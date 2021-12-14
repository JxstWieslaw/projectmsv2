package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Supplier;
import ga.linuxcafe.pms.parameters.services.CountryService;
import ga.linuxcafe.pms.parameters.services.StateService;
import ga.linuxcafe.pms.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired  private SupplierService supplierService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/parameters/suppliers")
    public String getSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/supplier";
    }

    @PostMapping("/parameters/suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @RequestMapping("/parameters/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id) {
        return supplierService.getById(id);
    }

    @RequestMapping(value="/parameters/suppliers/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @RequestMapping(value="/parameters/suppliers/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/parameters/suppliers";
    }
}
