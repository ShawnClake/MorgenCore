package com.shawnclake.morgencore.core.component.objects.advanced;

public class AdvancedObject {

    /**
     * Returns arbitrary data about the object as a string
     * @return
     */
    public String __str__()
    {
        return this.toString();
    }

    /**
     * Returns the representation of an object as a string
     * @return
     */
    public String __repr__()
    {
        return this.__str__();
    }

    /**
     * Return -1 for less than
     * Return 0 for equality
     * Return 1 for greater than
     * @param obj
     * @return
     */
    public Integer __compare__(Object obj) throws Exception
    {
        throw new Exception("Compare is not implemented on this object");
    }

    public String __json__()
    {
        return this.__str__();
    }

}
