package com.kelvin.haversinedistance;

import com.kelvin.haversinedistance.model.CalculateDistance;
import com.kelvin.haversinedistance.model.Distance;
import com.kelvin.haversinedistance.model.Postcode;
import com.kelvin.haversinedistance.service.DistanceService;
import com.kelvin.haversinedistance.service.PostcodeService;
import com.kelvin.haversinedistance.util.NumberUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HaversineDistanceApplicationTests {

    public static String CONTROL_DATA_POSTCODE_A = "AB10 1XG";
    public static String CONTROL_DATA_POSTCODE_B = "AB10 6RN";

    /*
        ref: https://www.vcalc.com/wiki/vCalc/Haversine+-+Distance
        control data: between 57.144156, -2.114864 and 57.137871, -2.121487 equals 0.81
     */
    @Test
    void ShouldReturnCorrectDistance() {
        PostcodeService mockPostcodeService = Mockito.mock(PostcodeService.class);

        Mockito.when(mockPostcodeService.findPostcode(CONTROL_DATA_POSTCODE_A))
                .thenReturn(new Postcode().postcode(CONTROL_DATA_POSTCODE_A).latitude(57.1441560).longitude(-2.1148640));
        Mockito.when(mockPostcodeService.findPostcode(CONTROL_DATA_POSTCODE_B))
                .thenReturn(new Postcode().postcode(CONTROL_DATA_POSTCODE_B).latitude(57.1378710).longitude(-2.1214870));

        DistanceService distanceService = new DistanceService(mockPostcodeService);

        Distance distance = distanceService.calculateDistance(new CalculateDistance().postcodeA(CONTROL_DATA_POSTCODE_A).postcodeB(CONTROL_DATA_POSTCODE_B));

        Assertions.assertEquals(NumberUtil.round(distance.getDistance()), 0.81);
        Assertions.assertEquals(distance.getUnit(), "km");
        Assertions.assertEquals(distance.getPostcodeA().getPostcode(), CONTROL_DATA_POSTCODE_A);
        Assertions.assertEquals(distance.getPostcodeB().getPostcode(), CONTROL_DATA_POSTCODE_B);
    }
}
