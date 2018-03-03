package com.shawnclake.morgencore.core.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Collections {

    public static <T> T random(ArrayList<T> list)
    {
        int size = list.size();

        if(size == 0)
            return null;

        int index = Numbers.randomInt(0, size);

        return list.get(index);
    }

    public static <T> T random(HashSet<T> hashList)
    {
        return random(new ArrayList<>(hashList));
    }

    public static String[] toArray(ArrayList<String> strings)
    {
        return strings.toArray(new String[0]);
    }

    public static <T> List<T> toList(T[] arr)
    {
        return Arrays.asList(arr);
    }

    public static <T> ArrayList<T> toArrayList(T[] arr)
    {
        return new ArrayList<T>(Arrays.asList(arr));
    }

}
