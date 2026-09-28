package _AD063.pro.Services;

import _AD063.pro.Models.Escalation;
import _AD063.pro.Repository.EscalationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscalationServices {

    @Autowired
    private EscalationRepository escalationRepository;

    public Escalation createEscalation(Escalation data) {
        Escalation result = escalationRepository.save(data);
        return result;
    }

    public List<Escalation> getAllEscalations() {
        return escalationRepository.findAll();
    }

    public Escalation updateEscalation(Escalation data) {
        return escalationRepository.save(data);
    }

    public Escalation getById(Long id) {
        return escalationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escalation not found"));
    }

    public void deleteEscalation(Long id) {
        escalationRepository.deleteById(id);
    }
}
