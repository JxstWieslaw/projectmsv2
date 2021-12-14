package ga.linuxcafe.pms.hr.controllers;

import ga.linuxcafe.pms.hr.models.Department;
import ga.linuxcafe.pms.hr.services.DepartmentService;
import ga.linuxcafe.pms.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //View Department List form.
    @GetMapping("/hr/departments")
    public String getDepartmentsList(Model model){
        model.addAttribute("departments",departmentService.getAll());
        return "hr/departments";
    }

    //View New Department Form
    @GetMapping("/hr/departmentAdd")
    public String addDepartment(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "hr/departmentAdd";
    }
    //Save A new Department
    @PostMapping("/hr/departments/save")
    public String save(Department department){
        departmentService.save(department);
        return "redirect:/hr/departments";
    }


    //Update a Department Record
    //View Update form
    @GetMapping("/hr/departmentEdit/{id}")
    public String editDepartment(@PathVariable Integer id, Model model){
        model.addAttribute("department",departmentService.getById(id));
        model.addAttribute("employees", employeeService.getAll());
        return "hr/departmentEdit";
    }

    //View Details Page
    @GetMapping("/hr/departmentDetails/{id}")
    public String detailsDepartment(@PathVariable Integer id, Model model){
        model.addAttribute("department",departmentService.getById(id));
        model.addAttribute("employees", employeeService.getAll());
        return "hr/departmentDetails";
    }


    //Save update
    @RequestMapping(value="/hr/departments/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Department department){
        departmentService.save(department);
        return "redirect:/hr/departments";
    }

    //Delete A department
    @RequestMapping(value="/hr/departments/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        departmentService.delete(id);
        return "redirect:/hr/departments";
    }
}
