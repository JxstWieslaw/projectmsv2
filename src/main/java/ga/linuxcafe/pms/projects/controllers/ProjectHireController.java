package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.parameters.services.ClientService;
import ga.linuxcafe.pms.projects.models.ProjectHire;
import ga.linuxcafe.pms.projects.services.ProjectHireService;
import ga.linuxcafe.pms.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectHireController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectHireService projectHireService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("projects", projectService.getAll());
        return model;
    }

    //View Project List form.
    @GetMapping("/projects/projectHires")
    public String getProjectsList(Model model){
        model.addAttribute("projectHires",projectHireService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("projects", projectService.getAll());
        return "projects/projectHire";
    }


    //View New Project Form
    @GetMapping("/projects/projectHireAdd")
    public String addProject(Model model){
        addModelAttributes(model);
        return "projects/projectHireAdd";
    }

    //Save A new Project
    @PostMapping("/projects/projectHires/save")
    public String save(ProjectHire projectHire){
        projectHireService.save(projectHire);
        return "redirect:/projects/projectHires";
    }


    //Update a Project Record
    //View Update form
    @GetMapping("/projects/projectHireEdit/{id}")
    public String editProject(@PathVariable Integer id, Model model){
        model.addAttribute("projectHire",projectHireService.getById(id));
        addModelAttributes(model);
        return "projects/projectHireEdit";
    }

    //View Details Page
    @GetMapping("/projects/projectHireDetails/{id}")
    public String detailsProject(@PathVariable Integer id, Model model){
        model.addAttribute("projectHire",projectHireService.getById(id));
        addModelAttributes(model);
        return "projects/projectHireDetails";
    }


    //Save update
    @RequestMapping(value="/projects/projectHires/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(ProjectHire projectHire){
        projectHireService.save(projectHire);
        return "redirect:/projects/projectHires";
    }

    //Delete A projectHire
    @RequestMapping(value="/projects/projectHires/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        projectHireService.delete(id);
        return "redirect:/projects/projectHires";
    }
}
