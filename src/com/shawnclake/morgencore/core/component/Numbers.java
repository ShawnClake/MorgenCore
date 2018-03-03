package com.shawnclake.morgencore.core.component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Numbers {

    public static double round(double value, int places)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int roundToInt(double value)
    {
        return (int)Numbers.round(value, 0);
    }

    public static boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public static double randomDouble(double min, double max)
    {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static float randomFloat(float min, float max)
    {
        return (ThreadLocalRandom.current().nextFloat() * (max - min)) + min;
    }

    public static int randomInt(int min, int max)
    {
        return (new Random().nextInt(max - min)) + min;
    }

    public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
        return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
    }

    public static double clamp(double input, double lowerBound, double upperBound)
    {
        if(input < lowerBound)
            return lowerBound;

        if(input > upperBound)
            return upperBound;

        return input;
    }

    public static double clampLowerBound(double input, double lowerBound)
    {
        if(input < lowerBound)
            return lowerBound;

        return input;
    }

    public static double clampUpperBound(double input, double upperBound)
    {
        if(input > upperBound)
            return upperBound;

        return input;
    }

}
