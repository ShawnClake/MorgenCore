package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedLong extends AdvancedObject {

    private java.lang.Long data;

    public AdvancedLong(java.lang.Long data) {
        this.data = data;
    }

    public java.lang.Long getData() {
        return data;
    }

    public void setData(java.lang.Long data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedLong)
        {
            AdvancedLong compareTo = (AdvancedLong)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.longValue() == compareTo.data.longValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Long)
        {
            return this.__compare__(new AdvancedLong((java.lang.Long)obj));
        }

        throw new Exception("AdvancedLong does not support comparing to other objects except AdvancedLong");
    }
    
}
