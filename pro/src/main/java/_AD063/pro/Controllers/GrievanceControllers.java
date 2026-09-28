package _AD063.pro.Controllers;

import _AD063.pro.Models.Grievance;
import _AD063.pro.Services.GrievanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grievance")
public class GrievanceControllers{

    @Autowired
    private GrievanceServices grievanceServices;

    // req body
    @PostMapping("/create")
    ResponseEntity<Grievance> createGrievance(@RequestBody Grievance body) {
        return new ResponseEntity<>(
                grievanceServices.createGrievance(body),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    ResponseEntity<List<Grievance>> getAll() {
        return new ResponseEntity<>(
                grievanceServices.getAllGrievances(),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    ResponseEntity<Grievance> updateGrievance(@RequestBody Grievance data) {
        return new ResponseEntity<>(
                grievanceServices.updateGrievance(data),
                HttpStatus.ACCEPTED
        );
    }

    // path variable
    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getById(@PathVariable long id) {
        try {
            Grievance response = grievanceServices.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteGrievance(@PathVariable long id) {
        try {
            grievanceServices.deleteGrievance(id);
            return new ResponseEntity<>("Grievance deleted successfully", HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Grievance not found", HttpStatus.NOT_FOUND);
        }
    }
}