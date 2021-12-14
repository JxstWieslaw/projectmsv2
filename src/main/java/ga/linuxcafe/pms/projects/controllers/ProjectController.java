package ga.linuxcafe.pms.projects.controllers;

import ga.linuxcafe.pms.hr.models.Employee;
import ga.linuxcafe.pms.hr.services.EmployeeService;
import ga.linuxcafe.pms.parameters.services.ClientService;
import ga.linuxcafe.pms.parameters.services.ProjectPriorityService;
import ga.linuxcafe.pms.parameters.services.ProjectStageService;
import ga.linuxcafe.pms.projects.models.Project;
import ga.linuxcafe.pms.projects.services.ProjectService;
import ga.linuxcafe.pms.projects.services.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectTypeService projectTypeService;
    @Autowired
    private ProjectStageService projectStageService;
    @Autowired
    private ProjectPriorityService projectPriorityService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("projectTypes", projectTypeService.getAll());
        model.addAttribute("projectStages", projectStageService.getAll());
        model.addAttribute("projectPriorities", projectPriorityService.getAll());
        return model;
    }
    //View Project List form.
    @GetMapping("/projects/projects")
    public String getProjectsList(Model model){
        model.addAttribute("projects",projectService.getAll());
        return "projects/project";
    }


    //View New Project Form
    @GetMapping("/projects/projectAdd")
    public String addProject(Model model){
        Iterable<Employee> allEmployees = employeeService.getAll();
        model.addAttribute("employees", allEmployees);
        addModelAttributes(model);
        return "projects/projectAdd";
    }

    //Save A new Project
    @PostMapping("/projects/projects/save")
    public String save(Project project){
        projectService.save(project);
        return "redirect:/projects/projects";
    }


    //Update a Project Record
    //View Update form
    @GetMapping("/projects/projectEdit/{id}")
    public String editProject(@PathVariable Integer id, Model model){
        model.addAttribute("project",projectService.getById(id));
        model.addAttribute("employees", employeeService.getAll());
        addProject(model);
        return "projects/projectEdit";
    }

    //View Details Page
    @GetMapping("/projects/projectDetails/{id}")
    public String detailsProject(@PathVariable Integer id, Model model){
        model.addAttribute("project",projectService.getById(id));
        Iterable<Employee> allEmployees = employeeService.getAll();
        model.addAttribute("employees", allEmployees);
        addModelAttributes(model);
        return "projects/projectDetails";
    }


    //Save update
    @RequestMapping(value="/projects/projects/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Project project){
        projectService.save(project);
        return "redirect:/projects/projects";
    }

    //Delete A project
    @RequestMapping(value="/projects/projects/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        projectService.delete(id);
        return "redirect:/projects/projects";
    }
}
