package _AD063.pro.Controllers;

import _AD063.pro.Models.Department;
import _AD063.pro.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentControllers {

    @Autowired
    private DepartmentServices departmentServices;

    // req body
    @PostMapping("/create")
    ResponseEntity<Department> createDepartment(@RequestBody Department body) {
        return new ResponseEntity<>(
                departmentServices.createDepartment(body),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    ResponseEntity<List<Department>> getAll() {
        return new ResponseEntity<>(
                departmentServices.getAllDepartments(),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    ResponseEntity<Department> updateDepartment(@RequestBody Department data) {
        return new ResponseEntity<>(
                departmentServices.updateDepartment(data),
                HttpStatus.ACCEPTED
        );
    }

    // path variable
    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getById(@PathVariable long id) {
        try {
            Department response = departmentServices.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteDepartment(@PathVariable long id) {
        try {
            departmentServices.deleteDepartment(id);
            return new ResponseEntity<>(
                    "Department deleted successfully",
                    HttpStatus.OK
            );
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "Department not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }
}