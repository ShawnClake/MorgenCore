package com.shawnclake.morgencore.core.component.property;

import com.shawnclake.morgencore.core.component.DynamicPrimitive;

import java.util.HashMap;

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