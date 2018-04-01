package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedDouble extends AdvancedObject {

    private java.lang.Double data;

    public AdvancedDouble(java.lang.Double data) {
        this.data = data;
    }

    public java.lang.Double getData() {
        return data;
    }

    public void setData(java.lang.Double data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedDouble)
        {
            AdvancedDouble compareTo = (AdvancedDouble)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.doubleValue() == compareTo.data.doubleValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Double)
        {
            return this.__compare__(new AdvancedDouble((java.lang.Double)obj));
        }

        throw new Exception("AdvancedDouble does not support comparing to other objects except AdvancedDouble");
    }
    
}
