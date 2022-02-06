package ga.linuxcafe.pms.restapis;

import ga.linuxcafe.pms.parameters.models.Country;
import ga.linuxcafe.pms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    //View Country List form.
    @GetMapping("/api/parameters/countries")
    public List<Country> getCountriesList(Model model){
        List<Country> countries =  countryService.getAll();
        return countries;
    }

    //The Get Country By Id
    @GetMapping("/api/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }
}
