package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.parameters.services.PercentCompleteService;
import ga.linuxcafe.pms.parameters.services.ProjectPriorityService;
import ga.linuxcafe.pms.parameters.services.ProjectStageService;
import ga.linuxcafe.pms.projects.models.Project;
import ga.linuxcafe.pms.projects.models.ProjectStatus;
import ga.linuxcafe.pms.projects.services.ProjectService;
import ga.linuxcafe.pms.projects.services.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectStatusController {

    @Autowired
    private ProjectStatusService projectStatusService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectStageService projectStageService;
    @Autowired
    private PercentCompleteService percentCompleteService;
    @Autowired
    private ProjectPriorityService projectPriorityService;

    Model addModelAttributes(Model model){
        model.addAttribute("projects",projectService.getAll());
        model.addAttribute("projectStages",projectStageService.getAll());
        model.addAttribute("percentCompletion",percentCompleteService.getAll());
        return model;
    }
    @GetMapping("/projects/projectStatuses")
    public String getProjectList(Model model){
        model.addAttribute("projectStatuses",projectStatusService.getAll());
        model.addAttribute("projectPriorities",projectPriorityService.getAll());
        model.addAttribute("projectStatuses",projectService.projectProjectStatus());
        return "projects/projectStatus";
    }

    //View New ProjectStatus Form
    @GetMapping("/projects/projectStatusAdd")
    public String addProjectStatus(Model model){
        addModelAttributes(model);
        return "projects/projectStatusAdd";
    }

    //Save A new ProjectStatus
    @PostMapping("/projects/projectStatuses/save")
    public String save(ProjectStatus projectStatus , @RequestParam Integer project ){
        projectStatusService.save(projectStatus);
        Project selectedProject = projectService.getById(project);
        selectedProject.setProjectStatus(projectStatus);
        projectService.save(selectedProject);
        return "redirect:/projects/projectStatuses";
    }

    //Update a ProjectStatus Record
    //View Update form
    @GetMapping("/projects/projectStatusEdit/{id}")
    public String editProjectStatus(@PathVariable Integer id, Model model){
        model.addAttribute("projectStatus",projectStatusService.getById(id));
        addModelAttributes(model);
        return "projects/projectStatusEdit";
    }

    //View Details Page
    @GetMapping("/projects/projectStatusDetails/{id}")
    public String detailsProjectStatus(@PathVariable Integer id, Model model){
        addModelAttributes(model);
        return "projects/projectStatusDetails";
    }


    //Save update
    @RequestMapping(value="/projects/projectStatuses/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(ProjectStatus projectStatus){
        projectStatusService.save(projectStatus);
        return "redirect:/projects/projectStatuses";
    }

    //Delete A projectStatus
    @RequestMapping(value="/projects/projectStatuses/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        projectStatusService.delete(id);
        return "redirect:/projects/projectStatuses";
    }
}
