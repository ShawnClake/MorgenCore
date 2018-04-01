package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedByte extends AdvancedObject {

    private java.lang.Byte data;

    public AdvancedByte(java.lang.Byte data) {
        this.data = data;
    }

    public java.lang.Byte getData() {
        return data;
    }

    public void setData(java.lang.Byte data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedByte)
        {
            AdvancedByte compareTo = (AdvancedByte)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.byteValue() == compareTo.data.byteValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Byte)
        {
            return this.__compare__(new AdvancedByte((java.lang.Byte)obj));
        }

        throw new Exception("AdvancedByte does not support comparing to other objects except AdvancedByte");
    }
    
}
