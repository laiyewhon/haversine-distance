package com.kelvin.haversinedistance.service;

import com.kelvin.haversinedistance.model.CalculateDistance;
import com.kelvin.haversinedistance.model.Distance;
import com.kelvin.haversinedistance.model.Postcode;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    private final static double EARTH_RADIUS = 6371; // radius in kilometers
    private final PostcodeService postcodeService;

    public DistanceService(PostcodeService postcodeService) {
        this.postcodeService = postcodeService;
    }

    public Distance calculateDistance(CalculateDistance request) {
        Postcode postcodeA = postcodeService.findPostcode(request.getPostcodeA());
        Postcode postcodeB = postcodeService.findPostcode(request.getPostcodeB());

        return new Distance()
                .distance(calculateDistance(postcodeA.getLatitude(), postcodeA.getLongitude(), postcodeB.getLatitude(), postcodeB.getLongitude()))
                .postcodeA(new Postcode().latitude(postcodeA.getLatitude()).longitude(postcodeA.getLongitude()).postcode(postcodeA.getPostcode()))
                .postcodeB(new Postcode().latitude(postcodeB.getLatitude()).longitude(postcodeB.getLongitude()).postcode(postcodeB.getPostcode()))
                .unit("km");
    }

    private double calculateDistance(double latitude, double longitude, double latitude2, double
            longitude2) {
        // Using Haversine formula! See Wikipedia;
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);
        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS * c);
    }

    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }
}
