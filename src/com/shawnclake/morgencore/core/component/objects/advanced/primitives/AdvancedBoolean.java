package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedBoolean extends AdvancedObject {

    private java.lang.Boolean data;

    public AdvancedBoolean(java.lang.Boolean data) {
        this.data = data;
    }

    public java.lang.Boolean getData() {
        return data;
    }

    public void setData(java.lang.Boolean data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedBoolean)
        {
            AdvancedBoolean compareTo = (AdvancedBoolean)obj;

            if(this.data && !compareTo.data)
                return 1;
            else if(!this.data && compareTo.data)
                return -1;
            else if(this.data.booleanValue() == compareTo.data.booleanValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Boolean)
        {
            return this.__compare__(new AdvancedBoolean((java.lang.Boolean)obj));
        }

        throw new Exception("AdvancedBoolean does not support comparing to other objects except AdvancedBoolean");
    }

}
