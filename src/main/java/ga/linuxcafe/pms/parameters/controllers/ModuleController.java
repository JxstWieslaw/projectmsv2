package ga.linuxcafe.pms.parameters.controllers;

import ga.linuxcafe.pms.parameters.models.Module;
import ga.linuxcafe.pms.parameters.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/parameters/modules")
    public String getModules(Model model) {
        List<Module> moduleList = moduleService.getAll();
        model.addAttribute("modules", moduleList);
        return "parameters/modules";
    }

    @PostMapping("/parameters/modules/addNew")
    public String addNew(Module module) {
        moduleService.save(module);
        return "redirect:/parameters/modules";
    }

    @RequestMapping("/parameters/modules/findById")
    @ResponseBody
    public Optional<Module> findById(int id) {
        return moduleService.getById(id);
    }

    @RequestMapping(value="/parameters/modules/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Module module) {
        moduleService.save(module);
        return "redirect:/parameters/modules";
    }

    @RequestMapping(value="/parameters/modules/delete/{id}" ,method={RequestMethod.GET,RequestMethod.DELETE})
    public String deleteForReal(@PathVariable Integer id){
        moduleService.delete(id);
        return "redirect:/parameters/modules";
    }
}
