package com.kelvin.haversinedistance.service;

import com.kelvin.haversinedistance.entity.Postcode;
import com.kelvin.haversinedistance.exception.ValidationException;
import com.kelvin.haversinedistance.model.UpdatePostcode;
import com.kelvin.haversinedistance.repository.PostcodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostcodeService {
    private final PostcodeRepository postcodeRepository;

    public PostcodeService(PostcodeRepository postcodeRepository) {
        this.postcodeRepository = postcodeRepository;
    }

    private static com.kelvin.haversinedistance.model.Postcode toModel(Postcode entity) {
        return new com.kelvin.haversinedistance.model.Postcode()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .postcode(entity.getPostcode());
    }

    public com.kelvin.haversinedistance.model.Postcode findPostcode(String postcode) {
        return toModel(postcodeRepository.findByPostcode(postcode)
                .orElseThrow(() -> new ValidationException("Invalid Postcode")));
    }

    @Transactional
    public void updatePostcode(String postcode,
                               UpdatePostcode updatePostcode) {
        Postcode entity = postcodeRepository.findByPostcode(postcode)
                .orElseThrow(() -> new ValidationException("Invalid Postcode"));

        entity.setLatitude(updatePostcode.getLatitude());
        entity.setLongitude(updatePostcode.getLongitude());

        postcodeRepository.save(entity);
    }
}
