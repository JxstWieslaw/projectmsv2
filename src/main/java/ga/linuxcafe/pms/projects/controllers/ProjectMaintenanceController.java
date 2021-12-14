package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.hr.services.EmployeeService;
import ga.linuxcafe.pms.projects.models.ProjectMaintenance;
import ga.linuxcafe.pms.projects.services.ProjectMaintenanceService;
import ga.linuxcafe.pms.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectMaintenanceController {

    @Autowired
    private ProjectMaintenanceService projectMaintenanceService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

    Model addModelAttributes(Model model){
        model.addAttribute("projects",projectService.getAll());
        model.addAttribute("employees",employeeService.getAll());
        return model;
    }
    @GetMapping("/projects/projectMaintenance")
    public String getProjectList(Model model){
        model.addAttribute("projectMaintenances",projectMaintenanceService.getAll());
        return "projects/projectMaintenance";
    }


    //View New ProjectMaintenance Form
    @GetMapping("/projects/projectMaintenanceAdd")
    public String addProjectMaintenance(Model model){
        addModelAttributes(model);
        return "projects/projectMaintenanceAdd";
    }

    //Save A new ProjectMaintenance
    @PostMapping("/projects/projectMaintenance/save")
    public String save(ProjectMaintenance projectMaintenance){
        projectMaintenanceService.save(projectMaintenance);
        return "redirect:/projects/projectMaintenance";
    }


    //Update a ProjectMaintenance Record
    //View Update form
    @GetMapping("/projects/projectMaintenanceEdit/{id}")
    public String editProjectMaintenance(@PathVariable Integer id, Model model){
        model.addAttribute("projectMaintenance",projectMaintenanceService.getById(id));
        addModelAttributes(model);
        return "projects/projectMaintenanceEdit";
    }

    //View Details Page
    @GetMapping("/projects/projectMaintenanceDetails/{id}")
    public String detailsProjectMaintenance(@PathVariable Integer id, Model model){
        model.addAttribute("projectMaintenance",projectMaintenanceService.getById(id));
        addModelAttributes(model);
        return "projects/projectMaintenanceDetails";
    }

    //Save update
    @RequestMapping(value="/projects/projectMaintenance/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(ProjectMaintenance projectMaintenance){
        projectMaintenanceService.save(projectMaintenance);
        return "redirect:/projects/projectMaintenance";
    }

    //Delete A projectMaintenance
    @RequestMapping(value="/projects/projectMaintenance/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        projectMaintenanceService.delete(id);
        return "redirect:/projects/projectMaintenance";
    }
}
