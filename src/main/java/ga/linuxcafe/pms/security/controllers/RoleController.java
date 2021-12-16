package ga.linuxcafe.pms.security.controllers;

import ga.linuxcafe.pms.security.models.Role;
import ga.linuxcafe.pms.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController {

    @Autowired  private RoleService roleService;

    @GetMapping("/security/roles")
    public String getRoles(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "security/role";
    }

    @PostMapping("/security/roles/save")
    public String addNew(Role role) {
        roleService.save(role);
        return "redirect:/security/roles";
    }

    //Update a Role Record
    //View Update form
    @GetMapping("/security/roleEdit/{id}")
    public String editRole(@PathVariable Integer id, Model model){
        model.addAttribute("role",roleService.getById(id));
        return "security/roleEdit";
    }

    //Save update
    @RequestMapping(value="/security/roles/update/{id}", method={RequestMethod.GET,RequestMethod.PUT})
    public String update(Role department){
        roleService.save(department);
        return "redirect:/security/roles";
    }

    //View Details Page
    @GetMapping("/security/roleDetails/{id}")
    public String detailsRole(@PathVariable Integer id, Model model){
        model.addAttribute("role",roleService.getById(id));
        return "security/roleDetails";
    }

    @RequestMapping(value="/security/roles/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        roleService.delete(id);
        return "redirect:/security/roles";
    }

    //The assignRole() method
    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId){
        roleService.assignUserRole(userId, roleId);
        return "redirect:/security/userEdit/"+userId;
    }

    //The unAssignRole() method
    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId){
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/userEdit/"+userId;
    }

}
