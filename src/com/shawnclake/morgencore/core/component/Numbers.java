package com.shawnclake.morgencore.core.component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 * Helper methods to do with numbers
 */
public class Numbers {

    /**
     * Round a double value to n number of places
     * @param value
     * @param places
     * @return
     */
    public static double round(double value, int places)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Round a double to the nearest int
     * @param value
     * @return
     */
    public static int roundToInt(double value)
    {
        return (int)Numbers.round(value, 0);
    }

    /**
     * Returns whether a provided string could be converted to a number
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    /**
     * Returns a random double in the range [min, max)
     * @param min
     * @param max
     * @return
     */
    public static double randomDouble(double min, double max)
    {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    /**
     * Returns a random float in the range [min, max)
     * @param min
     * @param max
     * @return
     */
    public static float randomFloat(float min, float max)
    {
        return (ThreadLocalRandom.current().nextFloat() * (max - min)) + min;
    }

    /**
     * Returns a random int in the range [min, max)
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max)
    {
        return (new Random().nextInt(max - min)) + min;
    }

    /**
     * Scales a provided value from a previous base to a new base
     * ie. 5, 1, 10, 1, 100 would return 50 as we scale the 5 from a range of 1-10 to a range of 1-100
     * @param valueIn
     * @param baseMin
     * @param baseMax
     * @param limitMin
     * @param limitMax
     * @return
     */
    public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
        return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
    }

    /**
     * Clamps an input to a lower and higher bound inclusive
     * @param input
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static double clamp(double input, double lowerBound, double upperBound)
    {
        if(input < lowerBound)
            return lowerBound;

        if(input > upperBound)
            return upperBound;

        return input;
    }

    /**
     * Clamps an input to a lower bound inclusive
     * @param input
     * @param lowerBound
     * @return
     */
    public static double clampLowerBound(double input, double lowerBound)
    {
        if(input < lowerBound)
            return lowerBound;

        return input;
    }

    /**
     * Clamps an input to a higher bound inclusive
     * @param input
     * @param upperBound
     * @return
     */
    public static double clampUpperBound(double input, double upperBound)
    {
        if(input > upperBound)
            return upperBound;

        return input;
    }

}
