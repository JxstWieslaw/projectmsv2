package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Contact;
import ga.linuxcafe.pms.parameters.services.ContactService;
import ga.linuxcafe.pms.parameters.services.CountryService;
import ga.linuxcafe.pms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/parameters/contacts")
    public String getContacts(Model model) {
        List<Contact> contactList = contactService.getAll();
        model.addAttribute("contacts", contactList);
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/contact";
    }

    @PostMapping("/parameters/contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    @RequestMapping("/parameters/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id) {
        return contactService.getById(id);
    }

    @RequestMapping(value="/parameters/contacts/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    @RequestMapping(value="/parameters/contacts/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        contactService.delete(id);
        return "redirect:/parameters/contacts";
    }
}
