package com.shawnclake.morgencore.core.component;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.DynamicPrimitive;
import com.shawnclake.morgencore.core.component.property.Properties;

import java.util.HashMap;

/**
 * Quickly build meta data classes for some type of data and any type of meta associated with it
 * @param <T>
 */
abstract public class MetaData<T> extends Properties {

    protected T data;

    public T getData() {
        return data;
    }

    public HashMap<String, DynamicPrimitive> getMeta()
    {
        return this.getProperties();
    }

}
