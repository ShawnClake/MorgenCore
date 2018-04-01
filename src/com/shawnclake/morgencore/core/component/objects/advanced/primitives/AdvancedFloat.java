package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedFloat extends AdvancedObject {

    private java.lang.Float data;

    public AdvancedFloat(java.lang.Float data) {
        this.data = data;
    }

    public java.lang.Float getData() {
        return data;
    }

    public void setData(java.lang.Float data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedFloat)
        {
            AdvancedFloat compareTo = (AdvancedFloat)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.floatValue() == compareTo.data.floatValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Float)
        {
            return this.__compare__(new AdvancedFloat((java.lang.Float)obj));
        }

        throw new Exception("AdvancedFloat does not support comparing to other objects except AdvancedFloat");
    }
    
}
