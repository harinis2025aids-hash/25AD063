package _AD063.pro.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue
    Long Id;

    String DepartmentName;
    String OfficerName;
    String Contact;
}