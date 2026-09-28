package _AD063.pro.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Grievance {

    @Id
    @GeneratedValue
    Long Id;

    String CitizenName;
    String Category;
    String Description;
    String Location;
    String Status;
    int SlaDays;
}