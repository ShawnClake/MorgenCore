package com.shawnclake.morgencore.core.component.objects.advanced.primitives;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

public class AdvancedChar extends AdvancedObject {

    private java.lang.Character data;

    public AdvancedChar(java.lang.Character data) {
        this.data = data;
    }

    public java.lang.Character getData() {
        return data;
    }

    public void setData(java.lang.Character data) {
        this.data = data;
    }

    @Override
    public String __str__() {
        return data.toString();
    }

    @Override
    public java.lang.Integer __compare__(Object obj) throws Exception
    {
        if(obj instanceof AdvancedChar)
        {
            AdvancedChar compareTo = (AdvancedChar)obj;

            if(this.data < compareTo.data)
                return -1;
            else if(this.data > compareTo.data)
                return 1;
            else if(this.data.charValue() == compareTo.data.charValue())
                return 0;
            else
                throw new Exception("Comparison fails");
        }
        else if (obj instanceof java.lang.Character)
        {
            return this.__compare__(new AdvancedChar((java.lang.Character)obj));
        }

        throw new Exception("AdvancedChar does not support comparing to other objects except AdvancedChar");
    }
    
}
