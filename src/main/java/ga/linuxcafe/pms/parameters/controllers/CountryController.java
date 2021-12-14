package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Country;
import ga.linuxcafe.pms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    //View Country List form.
    @GetMapping("/parameters/countries")
    public String getCountriesList(Model model){
        List<Country> countries =  countryService.getAll();
        model.addAttribute("countries",countries);
        return "parameters/countries";
    }

    //The Get Country By Id
    @GetMapping("/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }

    //View New Country Form
    @GetMapping("/parameters/countryAdd")
    public String addCountry(){
        return "parameters/countryAdd";
    }


    //Save A new Country
    @PostMapping("/parameters/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/parameters/countries";
    }

    //Update a Country Record
    //View Update form
    @GetMapping("/parameters/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country",country);
        return "parameters/countryEdit";
    }

    //View Details Page
    @GetMapping("/parameters/countryDetails/{id}")
    public String detailsCountry(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country",country);
        return "parameters/countryDetails";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/country/{op}/{id}")
    public String editCountry(@PathVariable Integer id, @PathVariable String op, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "/parameters/country"+ op;
    }


    //Save update
    @RequestMapping(value="/parameters/countries/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Country country){
        countryService.save(country);
        return "redirect:/parameters/countries";
    }

    //Delete A country
    @RequestMapping(value="/parameters/countries/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }
}
