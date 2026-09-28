package _AD063.pro.Controllers;

import _AD063.pro.Models.Rating;
import _AD063.pro.Services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingControllers {

    @Autowired
    private RatingServices ratingServices;

    // req body
    @PostMapping("/create")
    ResponseEntity<Rating> createRating(@RequestBody Rating body) {
        return new ResponseEntity<>(
                ratingServices.createRating(body),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    ResponseEntity<List<Rating>> getAll() {
        return new ResponseEntity<>(
                ratingServices.getAllRatings(),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    ResponseEntity<Rating> updateRating(@RequestBody Rating data) {
        return new ResponseEntity<>(
                ratingServices.updateRating(data),
                HttpStatus.ACCEPTED
        );
    }

    // path variable
    @GetMapping("/getbyid/{id}")
    ResponseEntity<?> getById(@PathVariable long id) {
        try {
            Rating response = ratingServices.getById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteRating(@PathVariable long id) {
        try {
            ratingServices.deleteRating(id);
            return new ResponseEntity<>(
                    "Rating deleted successfully",
                    HttpStatus.OK
            );
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(
                    "Rating not found",
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
