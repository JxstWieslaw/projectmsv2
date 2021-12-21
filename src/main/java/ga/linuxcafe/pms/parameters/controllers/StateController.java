package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.State;
import ga.linuxcafe.pms.parameters.services.CountryService;
import ga.linuxcafe.pms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries",countryService.getAll());
        return model;
    }

    //Get All States
    @GetMapping("/parameters/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    //Saving an update
    @RequestMapping(value="/parameters/states/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.getById(id));
        return "parameters/state" + op;
    }

    //Add State
    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value="/parameters/states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }
}