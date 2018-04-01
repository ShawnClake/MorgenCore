package com.shawnclake.morgencore.core.component.objects;

import com.shawnclake.morgencore.core.component.Numbers;

public class PrimitiveConverter {

    public static boolean toBoolean(Object property)
    {
        if(property instanceof String)
        {
            String lowercase = ((String)property).toLowerCase();
            return Boolean.parseBoolean(lowercase);
        }
        else if(property instanceof Number)
        {
            if(((Number)property).intValue() != 0)
                return true;
        }
        else if(property instanceof Character)
        {
            if(Character.getNumericValue((Character)property) != 0)
                return true;
        }
        else if(property instanceof Boolean)
        {
            return ((Boolean) property);
        }

        return false;
    }

    public static int toInteger(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Integer.parseInt((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).intValue();
        }
        else if(property instanceof Character)
        {
            return Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static short toShort(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Short.parseShort((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).shortValue();
        }
        else if(property instanceof Character)
        {
            return (short)Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static long toLong(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Long.parseLong((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).longValue();
        }
        else if(property instanceof Character)
        {
            return Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static float toFloat(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Float.parseFloat((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).floatValue();
        }
        else if(property instanceof Character)
        {
            return Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static double toDouble(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Double.parseDouble((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).doubleValue();
        }
        else if(property instanceof Character)
        {
            return Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static byte toByte(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return Byte.parseByte((String)property);
        }
        else if(property instanceof Number)
        {
            return ((Number)property).byteValue();
        }
        else if(property instanceof Character)
        {
            return (byte)Character.getNumericValue((Character)property);
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

    public static char toChar(Object property)
    {
        if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
                return ((String)property).charAt(0);
        }
        else if(property instanceof Number)
        {
            return (char)((Number)property).intValue();
        }
        else if(property instanceof Character)
        {
            return (Character)property;
        }
        else if(property instanceof Boolean)
        {
            if(((Boolean)property))
                return 1;
        }

        return 0;
    }

}
