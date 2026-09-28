package _AD063.pro.Services;

import _AD063.pro.Models.Department;
import _AD063.pro.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department data) {
        Department result = departmentRepository.save(data);
        return result;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department data) {
        return departmentRepository.save(data);
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}