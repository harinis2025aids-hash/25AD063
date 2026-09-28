package _AD063.pro.Services;

import _AD063.pro.Models.Rating;
import _AD063.pro.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServices {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(Rating data) {
        Rating result = ratingRepository.save(data);
        return result;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating updateRating(Rating data) {
        return ratingRepository.save(data);
    }

    public Rating getById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}