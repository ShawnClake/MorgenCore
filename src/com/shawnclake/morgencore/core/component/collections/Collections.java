package com.shawnclake.morgencore.core.component.collections;

import com.shawnclake.morgencore.core.component.Numbers;

import java.util.*;

/**
 * Helper methods for dealing with various collections
 */
public class Collections {

    /**
     * Returns a random entry in an array list
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T random(ArrayList<T> list)
    {
        int size = list.size();

        if(size == 0)
            return null;

        int index = Numbers.randomInt(0, size);

        return list.get(index);
    }

    /**
     * Returns a random entry in a hash set
     * @param hashList
     * @param <T>
     * @return
     */
    public static <T> T random(HashSet<T> hashList)
    {
        return random(new ArrayList<>(hashList));
    }

    /**
     * Converts a string ArrayList to a regular array
     * @param strings
     * @return
     */
    public static String[] toArray(ArrayList<String> strings)
    {
        return strings.toArray(new String[0]);
    }

    /**
     * Converts an array of T type objects to a list of T type objects
     * @param arr
     * @param <T>
     * @return
     */
    /*public static <T> List<T> toList(T[] arr)
    {
        return Arrays.asList(arr);
    }*/

    /**
     * Converts an array of T type objects to an array list of T type objects
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> toArrayList(T[] arr)
    {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    /**
     * Converts a single T type object to a list of T type
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(T arr)
    {
        return Arrays.asList(arr);
    }

    /**
     * Converts a single T type object to a list of T type
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(T... arr)
    {
        return Arrays.asList(arr);
    }

    /**
     * Converts a single T type object to an array list of T type
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> toArrayList(T arr)
    {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    public static <T> void prefillListNull(ArrayList<T> list, int size)
    {
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
    }

    public static <T> void prefillList(ArrayList<T> list, T data, int size)
    {
        for (int i = 0; i < size; i++) {
            list.add(data);
        }
    }



}
