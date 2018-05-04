package com.shawnclake.morgencore.core.component.property;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;

import java.util.HashMap;
import java.util.Map;

// TODO: serialize and unserialize properties to save strings - this has now been sort of included as json, but lets
        // include an alternate method anyways
// TODO: encrypt/decrypt serialized strings

/**
 * Properties
 * A key, value relationship
 * Uses strings as the key and DynamicPrimitives as the value which makes properties
 * useful for storing many different types of data in one place
 */
public class Properties extends AdvancedObject {

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

    public Properties() {
    }

    public Properties(String key, DynamicPrimitive value) {
        this.add(key, value);
    }

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

    public Properties add(String key, DynamicPrimitive value)
    {
        this.properties.put(key, value);
        return this;
    }

    @Override
    public String __str__() {
        String str = "[";

        for(Map.Entry<String, DynamicPrimitive> entry : this.getProperties().entrySet())
        {
            String key = entry.getKey();
            String value = "";
            if(entry.getValue() != null)
                value = entry.getValue().__str__();

            str += "\n  " + key + " => " + value + ",";
        }

        str = str.substring(0, str.length() - 1) + "\n]";

        return str;
    }

    @Override
    public String __json__() {

        String str = "{";

        for(Map.Entry<String, DynamicPrimitive> entry : this.getProperties().entrySet())
        {
            String key = entry.getKey();
            String value = "";
            if(entry.getValue() != null)
                value = entry.getValue().__str__();

            str += "\n  \"" + key + "\": \"" + value + "\",";
        }

        str = str.substring(0, str.length() - 1) + "\n}";

        return str;
    }
}
