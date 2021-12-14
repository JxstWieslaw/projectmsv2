package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Client;
import ga.linuxcafe.pms.parameters.services.ClientService;
import ga.linuxcafe.pms.parameters.services.CountryService;
import ga.linuxcafe.pms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries",countryService.getAll());
        return model;
    }

    //View Client List form.
    @GetMapping("/parameters/clients")
    public String getClients(Model model){
        List<Client> clients =  clientService.getAll();
        model.addAttribute("clients",clients);
        return "parameters/clients";
    }


    //View New Client Form
    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model){
        model.addAttribute("countries",countryService.getAll());
        return "parameters/clientAdd";
    }


    //Save A new Client
    @PostMapping("/parameters/clients")
    public String save(Client client){
        clientService.save(client);
        return "redirect:/parameters/clients";
    }


    //Update a Client Record
    //View Update form
    @GetMapping("/parameters/clientEdit/{id}")
    public String editClient(@PathVariable Integer id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client",client);
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/clientEdit";
    }

    //View Details Page
    @GetMapping("/parameters/clientDetails/{id}")
    public String detailsClient(@PathVariable Integer id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client",client);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries",countryService.getAll());
        return "parameters/clientDetails";
    }


    //Save update
    @RequestMapping(value="/parameters/clients/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    //Delete A client
    @RequestMapping(value="/parameters/clients/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        clientService.delete(id);
        return "redirect:/parameters/clients";
    }
}
