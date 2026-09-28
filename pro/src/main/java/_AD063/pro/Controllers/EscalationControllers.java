package _AD063.pro.Controllers;

import _AD063.pro.Models.Escalation;
import _AD063.pro.Services.EscalationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escalation")
public class EscalationControllers {

    @Autowired
    private EscalationServices escalationServices;

    // req body
    @PostMapping("/create")
    ResponseEntity<Escalation> createEscalation(@RequestBody Escalation body) {
        return new ResponseEntity<>(
                escalationServices.createEscalation(body),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    ResponseEntity<List<Escalation>> getAll() {
        return new ResponseEntity<>(
                escalationServices.getAllEscalations(),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    ResponseEntity<Escalation> updateEscalation(@RequestBody Escalation data) {
        return new ResponseEntity<>(
                escalationServices.updateEscalation(data),
                HttpStatus.ACCEPTED
        );
    }

    // path variable
    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getById(@PathVariable long id) {
        try {
            Escalation response = escalationServices.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteEscalation(@PathVariable long id) {
        try {
            escalationServices.deleteEscalation(id);
            return new ResponseEntity<>("Escalation deleted successfully", HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("Escalation not found", HttpStatus.NOT_FOUND);
        }
    }
}
