package com.shawnclake.morgencore.core.component;

/**
 * Allows the storing of T type properties in a fixed wrapper
 * Supports: all primitives, string, any object
 * Eager loading will do all the possible conversions upon setting a property into the class
 *     - This is expensive and should be avoided unless nesseccary
 * NOTE: It is the developers responsibility to ensure the type they are setting in here is the type they are returning.
 *
 * todo: fix overflow cases
 * @param <T>
 */
public class DynamicPrimitive<T> {

    // The inputted Property
    private T property;

    // These are for primitive returns
    private int rint;
    private float rfloat;
    private double rdouble;
    private long rlong;
    private char rchar;
    private byte rbyte;
    private short rshort;
    private boolean rboolean;

    private boolean rintOverflow = false;
    private boolean rbyteOverflow = false;
    
    // Eager load the primitives
    // Default to lazy for run time reasons
    private boolean eager = false;

    public DynamicPrimitive() {
    }

    public DynamicPrimitive(T property) {
        this.property = property;
        // Below will eager load, let's not do that unless we specifically desire that
        //this.setPrim();
    }
    
    public DynamicPrimitive(T property, boolean eager) {
        this.property = property;
        this.eager = eager;
        if(this.eager)
          this.setPrim();
    }

    public DynamicPrimitive(String property) {
        this.setProperty(property);
    }

    public DynamicPrimitive(String property, boolean eager) {
        this.eager = eager;
        this.setProperty(property);
    }

    public T getProperty() {
        return property;
    }

    @SuppressWarnings("unchecked")
    public <Z> Z getProperty(Class<Z> returnType) {
        return (Z)(property);
    }

    /**
     * Takes a string and tries to set it by first checking if it is a primitive and if not will generally set it
     * @param property
     */
    @SuppressWarnings("unchecked")
    public void setProperty(String property) {
        if(property == null)
        {
            this.property = null;
            if(this.eager)
                this.setPrim();
        }
        else
        {
            if(this.getProperty() instanceof Boolean)
                this.changeProperty((T)Boolean.valueOf(property));
            else if(this.getProperty()instanceof Integer)
                this.changeProperty((T)Integer.valueOf(property));
            else if(this.getProperty()instanceof Short)
                this.changeProperty((T)Short.valueOf(property));
            else if(this.getProperty()instanceof Byte)
                this.changeProperty((T)Byte.valueOf(property));
            else if(this.getProperty()instanceof Long)
                this.changeProperty((T)Long.valueOf(property));
            else if(this.getProperty()instanceof Character)
                this.changeProperty((T)Character.valueOf(property.charAt(0)));
            else if(this.getProperty()instanceof Float)
                this.changeProperty((T)Float.valueOf(property));
            else if(this.getProperty()instanceof Double)
                this.changeProperty((T)Double.valueOf(property));
            else
                this.changeProperty((T)property);
        }


    }

    /**
     * Sets a property and will eager load if eager load has been set to true manually
     * @param prop
     */
    protected void changeProperty(T prop)
    {
        this.property = prop;
        if(this.eager)
            this.setPrim();
    }

    /**
     * Eager loads all the primitive holders with values
     */
    protected void setPrim()
    {
        if(property == null)
        {
            rint = 0;
            rbyte = (byte)rint;
            rdouble = rint;
            rfloat = rint;
            rlong = rint;
            rshort = (short)rint;
            rchar = (char)rint;
            rboolean = false;
        }

        else if(property instanceof String)
        {
            if(Numbers.isNumeric((String)property))
            {
                rint = Integer.parseInt((String)property);
                rdouble = Double.parseDouble((String)property);
                rfloat = Float.parseFloat((String)property);
                rlong = Long.parseLong((String)property);
                rshort = Short.parseShort((String)property);
            }

            rchar = ((String)property).charAt(0);

            rbyte = (byte)(((String)property).charAt(0));

            String lowercase = ((String)property).toLowerCase();
            rboolean = Boolean.parseBoolean(lowercase);
        }

        else if(property instanceof Number)
        {
            Number propertyNumber = (Number)property;
            rint = propertyNumber.intValue();
            if(rint > Byte.MAX_VALUE) {
                rbyte = 0;
                rbyteOverflow = true;
            }
            else if(rint < Byte.MIN_VALUE)
            {
                rbyte = 0;
                rbyteOverflow = true;
            }
            else
                rbyte = propertyNumber.byteValue();
            rdouble = propertyNumber.doubleValue();
            rfloat = propertyNumber.floatValue();
            rlong = propertyNumber.longValue();
            rshort = propertyNumber.shortValue();
            rchar = (char)rint;

            if(rint == 0)
                rboolean = false;
            else
                rboolean = true;
        }

        else if(property instanceof Character)
        {
            rchar = ((Character)property).charValue();
            rint = Character.getNumericValue(rchar);
            if(rint > Byte.MAX_VALUE) {
                rbyte = 0;
                rbyteOverflow = true;
            }
            else if(rint < Byte.MIN_VALUE)
            {
                rbyte = 0;
                rbyteOverflow = true;
            }
            else
                rbyte = (byte)rint;
            rdouble = rint;
            rfloat = rint;
            rlong = rint;
            rshort = (short)rint;

            if(rint == 0)
                rboolean = false;
            else
                rboolean = true;
        }

        else if(property instanceof Boolean)
        {
            rboolean = ((Boolean)property).booleanValue();
            if(rboolean)
                rint = 1;
            else
                rint = 0;

            rbyte = (byte)rint;
            rdouble = rint;
            rfloat = rint;
            rlong = rint;
            rshort = (short)rint;
            rchar = (char)rint;
        }


    }

    /**
     * Tries to return the property as a string
     * @return
     */
    public String getString()
    {
        return this.getProperty().toString();
    }

    /**
     * Returns the boolean primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public boolean getBoolean()
    {
        if(!this.eager)
        {
            if(property == null)
                rboolean = false;
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                if(propertyNumber.intValue() == 0)
                    rboolean = false;
                else
                    rboolean = true;
            }
            else if(property instanceof String)
            {
                rboolean = Boolean.parseBoolean((String)property);
            }
            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                if(Character.getNumericValue(rchar) == 0)
                    rboolean = false;
                else
                    rboolean = true;
            }
            else if(property instanceof Boolean)
                rboolean = ((Boolean)property).booleanValue();
            else
                rboolean =  false;
        }
        
        return rboolean;
    }

    /**
     * Returns the int primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public int getInt() { 
        if(!this.eager)
        {
            if(property == null)
                rint = 0;
            else if(property instanceof String)
            {
                rint = Integer.parseInt((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rint = propertyNumber.intValue();
            }
            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rint = Character.getNumericValue(rchar);
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rint = 1;
                else
                    rint = 0;
            }
            else
                rint = 0;
        
        }
        
        return rint;     
    }

    /**
     * Returns the short primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public short getShort() { 
        if(!this.eager)
        {
            if(property == null)
            {
                rshort = 0;
            }
            else if(property instanceof String)
            {
                rshort = Short.parseShort((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rshort = propertyNumber.shortValue();
            }

            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rshort = (short)Character.getNumericValue(rchar);
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rshort = 1;
                else
                    rshort = 0;
            }
            else
                rshort = 0;
        
        }
   
        return rshort; 
    }

    /**
     * Returns the long primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public long getLong() { 
        if(!this.eager)
        {
            if(property == null)
            {
                rlong = 0;
            }
            else if(property instanceof String)
            {
                rlong = Long.parseLong((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rlong = propertyNumber.longValue();
            }

            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rlong = Character.getNumericValue(rchar);
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rlong = 1;
                else
                    rlong = 0;
            }
            else
                rlong = 0;
        
        }
        return rlong; 
    }

    /**
     * Returns the float primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public float getFloat() { 
        if(!this.eager)
        {
            if(property == null)
            {
                rfloat = 0f;
            }
            else if(property instanceof String)
            {
                rfloat = Float.parseFloat((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rfloat = propertyNumber.floatValue();
            }

            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rfloat = Character.getNumericValue(rchar);
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rfloat = 1f;
                else
                    rfloat = 0f;
            }
            else
                rfloat = 0f;
        
        }
        return rfloat;     
    }

    /**
     * Returns the double primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public double getDouble() { 
    
        if(!this.eager)
        {
            if(property == null)
            {
                rdouble = 0.;
            }
            else if(property instanceof String)
            {
                rdouble = Double.parseDouble((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rdouble = propertyNumber.doubleValue();
            }

            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rdouble = Character.getNumericValue(rchar);
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rdouble = 1.;
                else
                    rdouble = 0.;
            }
            else
                rdouble = 0.;
        
        }
    
        return rdouble; 
    }

    /**
     * Returns the char primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public char getChar() { 
        if(!this.eager)
        {
            if(property == null)
                rchar = (char)0;
            else if(property instanceof String)
            {
                rchar = ((String)property).charAt(0);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                rchar = (char)propertyNumber.intValue();
            }

            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
            }

            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rchar = (char)1;
                else
                    rchar = (char)0;
            }
            else
                rchar = (char)0;
        }
        return rchar; 
    }

    /**
     * Returns the byte primitive.
     * Will do the conversion if eager is disabled (default)
     * @return
     */
    public byte getByte() { 
        if(!this.eager)
        {
            if(property == null)
                rbyte = (byte)0;
            else if(property instanceof String)
            {
                if(Integer.parseInt((String)property) > Byte.MAX_VALUE)
                {
                    rbyte = 0;
                    rbyteOverflow = true;
                }
                else
                    rbyte = Byte.parseByte((String)property);
            }
            else if(property instanceof Number)
            {
                Number propertyNumber = (Number)property;
                if(propertyNumber.intValue() > Byte.MAX_VALUE) {
                    rbyte = 0;
                    rbyteOverflow = true;
                }
                else if(propertyNumber.intValue() < Byte.MIN_VALUE)
                {
                    rbyte = 0;
                    rbyteOverflow = true;
                }
                else
                    rbyte = propertyNumber.byteValue();
            }
            else if(property instanceof Character)
            {
                rchar = ((Character)property).charValue();
                rbyte = (byte)Character.getNumericValue(rchar);
            }
            else if(property instanceof Boolean)
            {
                rboolean = ((Boolean)property).booleanValue();
                if(rboolean)
                    rbyte = (byte)1;
                else
                    rbyte = (byte)0;
            }
            else
                rbyte = (byte)0;
        }
        return rbyte; 
    }

}
