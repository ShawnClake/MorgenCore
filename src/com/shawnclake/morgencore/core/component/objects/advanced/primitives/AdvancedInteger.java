package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedInteger extends AdvancedObject {

    private java.lang.Integer data;

    public AdvancedInteger(java.lang.Integer data) {
        this.data = data;
    }

    public java.lang.Integer getData() {
        return data;
    }

    public void setData(java.lang.Integer data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedInteger)
        {
            AdvancedInteger compareTo = (AdvancedInteger)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.intValue() == compareTo.data.intValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Integer)
        {
            return this.__compare__(new AdvancedInteger((java.lang.Integer)obj));
        }

        throw new Exception("AdvancedInteger does not support comparing to other objects except AdvancedInteger");
    }
}
