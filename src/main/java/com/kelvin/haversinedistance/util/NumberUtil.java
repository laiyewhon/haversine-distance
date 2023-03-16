package com.kelvin.haversinedistance.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtil {
    public static double round(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(value));
    }
}
