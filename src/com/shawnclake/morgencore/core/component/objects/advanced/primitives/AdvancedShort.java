package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedShort extends AdvancedObject {

    private java.lang.Short data;

    public AdvancedShort(java.lang.Short data) {
        this.data = data;
    }

    public java.lang.Short getData() {
        return data;
    }

    public void setData(java.lang.Short data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedShort)
        {
            AdvancedShort compareTo = (AdvancedShort)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.shortValue() == compareTo.data.shortValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Short)
        {
            return this.__compare__(new AdvancedShort((java.lang.Short)obj));
        }

        throw new Exception("AdvancedShort does not support comparing to other objects except AdvancedShort");
    }
    
}
