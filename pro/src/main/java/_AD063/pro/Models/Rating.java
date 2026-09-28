package _AD063.pro.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue
    Long Id;

    Long GrievanceId;
    int Rating;
    String Feedback;
}