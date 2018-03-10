package com.shawnclake.morgencore.core.component;

import com.shawnclake.morgencore.core.component.property.Properties;

/**
 * An opionated properties set
 * This class is meant to make it easier to quickly set up 1 or 2 result properties,
 * in particular this is useful when returning from functions with more than one
 * return type desired
 */
public class Results extends Properties {

    public Results() {
    }

    public Results(DynamicPrimitive result) {
        this.add("morgen-main-result", result);
    }

    public Results(String result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(int result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(float result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(double result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(char result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(boolean result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(short result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(long result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(byte result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }

    public Results(Object result) {
        this.add("morgen-main-result", new DynamicPrimitive(result));
    }




    //

    /**
     * Adds many main results
     * @param results
     * @param <T>
     */
    private<T> void addManyResults(T... results)
    {
        int i =0;
        for(T result : results)
        {
            this.add("morgen-main-result"+i, new DynamicPrimitive(result));
            i++;
        }

        results = null;
    }

    public Results(DynamicPrimitive... results) {
        this.addManyResults(results);
    }

    public Results(String... results) {
        this.addManyResults(results);
    }

    public Results(int... results) {
        this.addManyResults(results);
    }

    public Results(float... results) {
        this.addManyResults(results);
    }

    public Results(double... results) {
        this.addManyResults(results);
    }

    public Results(char... results) {
        this.addManyResults(results);
    }

    public Results(boolean... results) {
        this.addManyResults(results);
    }

    public Results(short... results) {
        this.addManyResults(results);
    }

    public Results(long... results) {
        this.addManyResults(results);
    }

    public Results(byte... results) {
        this.addManyResults(results);
    }

    public Results(Object... results) {
        this.addManyResults(results);
    }


    //


    public void addResult(String key, DynamicPrimitive result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, String result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, int result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, float result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, double result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, char result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, boolean result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, short result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, long result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, byte result) {
        this.add(key, new DynamicPrimitive(result));
    }

    public void addResult(String key, Object result) {
        this.add(key, new DynamicPrimitive(result));
    }


    public DynamicPrimitive getMainResult()
    {
        return this.get("morgen-main-result");
    }

    public DynamicPrimitive getMainResults(int index)
    {
        return this.get("morgen-main-result"+index);
    }

    public DynamicPrimitive getResult(String key)
    {
        return this.get(key);
    }


}
