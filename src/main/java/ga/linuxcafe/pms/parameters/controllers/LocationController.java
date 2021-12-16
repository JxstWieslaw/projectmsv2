package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Location;
import ga.linuxcafe.pms.parameters.services.CountryService;
import ga.linuxcafe.pms.parameters.services.LocationService;
import ga.linuxcafe.pms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("locations", locationService.getAll());
        return model;
    }

    //View Location List form.
    @GetMapping("/parameters/locations")
    public String getCountriesList(Model model){
        List<Location> locations =  locationService.getAll();
        model.addAttribute("locations",locations);
        return "parameters/locations";
    }


    //View New Location Form
    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model){
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/locationAdd";
    }


    //Save A new Location
    @PostMapping("/parameters/locations")
    public String save(Location location){
        locationService.save(location);
        return "redirect:/parameters/locations";
    }


    //Update a Location Record
    //View Update form
    @GetMapping("/parameters/locationEdit/{id}")
    public String editLocation(@PathVariable Integer id, Model model){
        Location location = locationService.getById(id);
        model.addAttribute("location",location);
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/locationEdit";
    }

    //View Details Page
    @GetMapping("/parameters/locationDetails/{id}")
    public String detailsLocation(@PathVariable Integer id, Model model){
        Location location = locationService.getById(id);
        model.addAttribute("location",location);
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return "parameters/locationDetails";
    }


    //Save update
    @RequestMapping(value="/parameters/locations/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    //Delete A location
    @RequestMapping(value="/parameters/locations/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/parameters/locations";
    }
}
