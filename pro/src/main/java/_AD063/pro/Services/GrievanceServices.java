package _AD063.pro.Services;

import _AD063.pro.Models.Grievance;
import _AD063.pro.Repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrievanceServices {

    @Autowired
    private GrievanceRepository grievanceRepository;

    public Grievance createGrievance(Grievance data) {
        Grievance result = grievanceRepository.save(data);
        return result;
    }

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Grievance updateGrievance(Grievance data) {
        return grievanceRepository.save(data);
    }

    public Grievance getById(Long id) {
        return grievanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
    }

    public void deleteGrievance(Long id) {
        grievanceRepository.deleteById(id);
    }
}