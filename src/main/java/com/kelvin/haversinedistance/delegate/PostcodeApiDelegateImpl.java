package com.kelvin.haversinedistance.delegate;

import com.kelvin.haversinedistance.api.PostcodeApiDelegate;
import com.kelvin.haversinedistance.model.CalculateDistance;
import com.kelvin.haversinedistance.model.Distance;
import com.kelvin.haversinedistance.model.Postcode;
import com.kelvin.haversinedistance.model.UpdatePostcode;
import com.kelvin.haversinedistance.service.DistanceService;
import com.kelvin.haversinedistance.service.PostcodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostcodeApiDelegateImpl implements PostcodeApiDelegate {

    private final DistanceService distanceService;
    private final PostcodeService postcodeService;

    public PostcodeApiDelegateImpl(DistanceService distanceService, PostcodeService postcodeService) {
        this.distanceService = distanceService;
        this.postcodeService = postcodeService;
    }

    public ResponseEntity<Distance> calculateDistance(CalculateDistance calculateDistance) {
        return ResponseEntity.ok(distanceService.calculateDistance(calculateDistance));

    }

    public ResponseEntity<Postcode> postcodePostcodeGet(String postcode) {
        return ResponseEntity.ok(postcodeService.findPostcode(postcode));
    }

    public ResponseEntity<Void> updatePostcode(String postcode,
                                               UpdatePostcode updatePostcode) {
        postcodeService.updatePostcode(postcode, updatePostcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
