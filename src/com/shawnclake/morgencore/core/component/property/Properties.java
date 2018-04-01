package com.shawnclake.morgencore.core.component.property;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;

import java.util.HashMap;

// TODO: serialize and unserialize properties to save strings
// TODO: encrypt/decrypt serialized strings

/**
 * Properties
 * A key, value relationship
 * Uses strings as the key and DynamicPrimitives as the value which makes properties
 * useful for storing many different types of data in one place
 */
public class Properties {

    private HashMap<String, DynamicPrimitive> properties = new HashMap<>();

    public HashMap<String, DynamicPrimitive> getProperties() {
        return properties;
    }

    /*public String getString(String key)
    {
        if(!properties.containsKey(key))
            return null;
        return properties.get(key);
    }

    public void addString(String key, String value)
    {
        properties.put(key, value);
    }*/

    public boolean has(String key)
    {
        return properties.containsKey(key);
    }

    public DynamicPrimitive get(String key)
    {
        if(!properties.containsKey(key))
            return null;
        return this.properties.get(key);
    }

    public void add(String key, DynamicPrimitive value)
    {
        this.properties.put(key, value);
    }





}
