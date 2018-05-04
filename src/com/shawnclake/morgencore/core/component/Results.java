package com.shawnclake.morgencore.core.component;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.property.Properties;

/**
 * An opinionated properties set
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
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(int result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(float result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(double result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(char result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(boolean result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(short result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(long result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(byte result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
    }

    public Results(Object result) {
        this.add("morgen-main-result", new LazyDynamicPrimitive<>(result));
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
            this.add("morgen-main-result"+i, new LazyDynamicPrimitive<>(result));
            i++;
        }

        results = null; // Prevents Heap pollution
    }


    public Results addResult(String key, DynamicPrimitive result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, String result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, int result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, float result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, double result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, char result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, boolean result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, short result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, long result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, byte result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }

    public Results addResult(String key, Object result) {
        this.add(key, new LazyDynamicPrimitive<>(result));
        return this;
    }


    public DynamicPrimitive getResult()
    {
        return this.get("morgen-main-result");
    }

    public DynamicPrimitive getResult(int index)
    {
        return this.get("morgen-main-result"+index);
    }

    public DynamicPrimitive getResult(String key)
    {
        return this.get(key);
    }


}
