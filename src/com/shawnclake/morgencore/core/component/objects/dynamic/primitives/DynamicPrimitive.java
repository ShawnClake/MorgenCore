package com.shawnclake.morgencore.core.component.objects.dynamic.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

/**
 * Allows the storing of T type properties in a fixed wrapper
 * Supports: all primitives, string, any object
 * Eager loading will do all the possible conversions upon setting a property into the class
 *     - This is expensive and should be avoided unless nesseccary
 * NOTE: It is the developers responsibility to ensure the type they are setting in here is the type they are returning.
 *
 * todo: fix overflow cases
 * todo: override __repr__ and __str__ where repr shows status and str shows the current value
 * todo: override __compare__ to compare two dynamic primitives. Compare based on type T and not any of the conversions.
 *      todo: perhaps this could be done by only allowing comparing on dynamic prims which are set to advanced objects and then just call .__compare__ on the set value
 * @param <T>
 */
abstract public class DynamicPrimitive<T> extends AdvancedObject {

    // The inputted Property
    private T value;

    // Eager load the primitives
    // Default to lazy for run time reasons
    //private boolean eager = false;

    public DynamicPrimitive() {
        this.value = null;
        this.load();
    }

    @SuppressWarnings("unchecked")
    public DynamicPrimitive(T property) {
        this.value = property;
        this.load();
    }

    public T getProperty() {
        return value;
    }

    @SuppressWarnings("unchecked")
    public <Z> Z getProperty(Class<Z> returnType) {
        return (Z)value;
    }

    /**
     * Takes a string and tries to set it by first checking if it is a primitive and if not will generally set it
     * @param property
     */
    public void setProperty(T property)
    {
        this.value = property;
        this.load();
    }

    @Override
    public String __str__() {
        return this.getProperty().toString();
    }

    @Override
    public Integer __compare__(Object obj) throws Exception {
        if(this.getProperty() instanceof AdvancedObject)
            return ((AdvancedObject) this.getProperty()).__compare__(obj);
        throw new Exception("Cant call compare on a DynamicPrimitive which is loaded with a value which is not composed of AdvancedObject");
    }

    abstract public int getInt();
    abstract public long getLong();
    abstract public short getShort();
    abstract public float getFloat();
    abstract public double getDouble();
    abstract public char getChar();
    abstract public byte getByte();
    abstract public boolean getBoolean();
    abstract public boolean load();



}
