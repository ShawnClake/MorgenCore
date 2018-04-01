package com.shawnclake.morgencore.core.component.objects.dynamic.primitives;

import com.shawnclake.morgencore.core.component.objects.PrimitiveConverter;

/**
 * Preforms a conversion only upon request
 * Pros: Low memory usage
 * Cons: CPU Usage when requesting conversion
 */
public class LazyDynamicPrimitive<T> extends DynamicPrimitive<T> {

    public LazyDynamicPrimitive() {
    }

    public LazyDynamicPrimitive(T property) {
        super(property);
    }

    @Override
    public boolean load() {
        return true;
    }

    @Override
    public int getInt() {
        return PrimitiveConverter.toInteger(this.getProperty());
    }

    @Override
    public long getLong() {
        return PrimitiveConverter.toLong(this.getProperty());
    }

    @Override
    public short getShort() {
        return PrimitiveConverter.toShort(this.getProperty());
    }

    @Override
    public float getFloat() {
        return PrimitiveConverter.toFloat(this.getProperty());
    }

    @Override
    public double getDouble() {
        return PrimitiveConverter.toDouble(this.getProperty());
    }

    @Override
    public char getChar() {
        return PrimitiveConverter.toChar(this.getProperty());
    }

    @Override
    public byte getByte() {
        return PrimitiveConverter.toByte(this.getProperty());
    }

    @Override
    public boolean getBoolean() {
        return PrimitiveConverter.toBoolean(this.getProperty());
    }

}
