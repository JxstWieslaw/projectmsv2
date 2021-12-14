package ga.linuxcafe.pms.hr.services;

import ga.linuxcafe.pms.hr.models.Department;
import ga.linuxcafe.pms.hr.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public void delete(Integer id){
        departmentRepository.deleteById(id);
    }
    
    public Department getById(Integer id){
        return departmentRepository.findById(id).orElse(null);
    }
}
