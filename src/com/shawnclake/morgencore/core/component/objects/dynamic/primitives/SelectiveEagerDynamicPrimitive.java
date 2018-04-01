package com.shawnclake.morgencore.core.component.objects.dynamic.primitives;

import com.shawnclake.morgencore.core.component.collections.Collections;
import com.shawnclake.morgencore.core.component.objects.PrimitiveConverter;
import com.shawnclake.morgencore.core.component.objects.PrimitiveTypes;

import java.util.ArrayList;

/**
 * Eager loads only the desired conversions
 * Pros: No CPU when requesting a desired value
 * Cons: Large memory usage, CPU usage when requesting a non-desired value
 *
 * todo: override __repr__ and __str__ where repr shows selections and status and str shows current values of the primitives
 */
public class SelectiveEagerDynamicPrimitive<T> extends DynamicPrimitive<T> {

    private ArrayList<PrimitiveTypes> selections = new ArrayList<>();

    // These are for primitive returns
    private int rint;
    private float rfloat;
    private double rdouble;
    private long rlong;
    private char rchar;
    private byte rbyte;
    private short rshort;
    private boolean rboolean;

    public SelectiveEagerDynamicPrimitive(PrimitiveTypes... types) {
        this.selections.addAll(Collections.toList(types));
    }

    public SelectiveEagerDynamicPrimitive(T property, PrimitiveTypes... types) {
        super(property);
        this.selections.addAll(Collections.toList(types));

    }

    public ArrayList<PrimitiveTypes> getSelections() {
        return selections;
    }

    @Override
    public boolean load() {
        this.loadPrimitives();
        return true;
    }

    /**
     * Eager loads all the primitive holders with values
     */
    protected void loadPrimitives()
    {
        T property = this.getProperty();

        if(property == null)
        {
            rint = 0;
            rbyte = 0;
            rdouble = 0;
            rfloat = 0;
            rlong = 0;
            rshort = 0;
            rchar = 0;
            rboolean = false;
        } else {

            if(selections.contains(PrimitiveTypes.INTEGER))
                rint = PrimitiveConverter.toInteger(property);

            if(selections.contains(PrimitiveTypes.LONG))
                rlong = PrimitiveConverter.toLong(property);

            if(selections.contains(PrimitiveTypes.SHORT))
                rshort = PrimitiveConverter.toShort(property);

            if(selections.contains(PrimitiveTypes.FLOAT))
                rfloat = PrimitiveConverter.toFloat(property);

            if(selections.contains(PrimitiveTypes.DOUBLE))
                rdouble = PrimitiveConverter.toDouble(property);

            if(selections.contains(PrimitiveTypes.BYTE))
                rbyte = PrimitiveConverter.toByte(property);

            if(selections.contains(PrimitiveTypes.CHAR))
                rchar = PrimitiveConverter.toChar(property);

            if(selections.contains(PrimitiveTypes.BOOLEAN))
                rboolean = PrimitiveConverter.toBoolean(property);
        }

    }

    @Override
    public int getInt() {
        if(selections.contains(PrimitiveTypes.INTEGER))
            return rint;
        return PrimitiveConverter.toInteger(this.getProperty());
    }

    @Override
    public long getLong() {
        if(selections.contains(PrimitiveTypes.LONG))
            return rlong;
        return PrimitiveConverter.toLong(this.getProperty());
    }

    @Override
    public short getShort() {
        if(selections.contains(PrimitiveTypes.SHORT))
            return rshort;
        return PrimitiveConverter.toShort(this.getProperty());
    }

    @Override
    public float getFloat() {
        if(selections.contains(PrimitiveTypes.FLOAT))
            return rfloat;
        return PrimitiveConverter.toFloat(this.getProperty());
    }

    @Override
    public double getDouble() {
        if(selections.contains(PrimitiveTypes.DOUBLE))
            return rdouble;
        return PrimitiveConverter.toDouble(this.getProperty());
    }

    @Override
    public char getChar() {
        if(selections.contains(PrimitiveTypes.CHAR))
            return rchar;
        return PrimitiveConverter.toChar(this.getProperty());
    }

    @Override
    public byte getByte() {
        if(selections.contains(PrimitiveTypes.BYTE))
            return rbyte;
        return PrimitiveConverter.toByte(this.getProperty());
    }

    @Override
    public boolean getBoolean() {
        if(selections.contains(PrimitiveTypes.BOOLEAN))
            return rboolean;
        return PrimitiveConverter.toBoolean(this.getProperty());
    }
}
