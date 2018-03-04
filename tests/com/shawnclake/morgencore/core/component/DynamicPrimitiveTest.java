package com.shawnclake.morgencore.core.component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicPrimitiveTest {

    DynamicPrimitive dynamicPrimitive = new DynamicPrimitive();
    DynamicPrimitive dynamicPrimitiveEager = new DynamicPrimitive();

    @org.junit.Before
    public void setUp() throws Exception {
        dynamicPrimitive = new DynamicPrimitive("5", false);
        dynamicPrimitiveEager = new DynamicPrimitive("500", true);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getProperty() throws Exception {
        assertEquals("5", dynamicPrimitive.getProperty());
        assertEquals("500", dynamicPrimitiveEager.getProperty());
    }

    @org.junit.Test
    public void setProperty() throws Exception {

    }

    @org.junit.Test
    public void changeProperty() throws Exception {
        dynamicPrimitive.changeProperty("49");
        dynamicPrimitiveEager.changeProperty("499");
        assertEquals("49", dynamicPrimitive.getProperty());
        assertEquals("499", dynamicPrimitiveEager.getProperty());
    }

    @org.junit.Test
    public void getString() throws Exception {
        dynamicPrimitive.changeProperty("wtf");
        dynamicPrimitiveEager.changeProperty("billy joe bob");
        assertEquals("wtf", dynamicPrimitive.getString());
        assertEquals("billy joe bob", dynamicPrimitiveEager.getString());
    }

    @org.junit.Test
    public void getBoolean() throws Exception {
        dynamicPrimitive.changeProperty("true");
        dynamicPrimitiveEager.changeProperty("True");
        assertEquals(true, dynamicPrimitive.getBoolean());
        assertEquals(true, dynamicPrimitiveEager.getBoolean());

        dynamicPrimitive.changeProperty("False");
        dynamicPrimitiveEager.changeProperty("FALSE");
        assertEquals(false, dynamicPrimitive.getBoolean());
        assertEquals(false, dynamicPrimitiveEager.getBoolean());

        dynamicPrimitive.changeProperty(true);
        dynamicPrimitiveEager.changeProperty(false);
        assertEquals(true, dynamicPrimitive.getBoolean());
        assertEquals(false, dynamicPrimitiveEager.getBoolean());

        dynamicPrimitive.changeProperty(1);
        dynamicPrimitiveEager.changeProperty(0);
        assertEquals(true, dynamicPrimitive.getBoolean());
        assertEquals(false, dynamicPrimitiveEager.getBoolean());
    }

    @org.junit.Test
    public void getInt() throws Exception {
        dynamicPrimitive.changeProperty(50);
        dynamicPrimitiveEager.changeProperty(100);
        assertEquals(50, dynamicPrimitive.getInt());
        assertEquals(100, dynamicPrimitiveEager.getInt());

        dynamicPrimitive.changeProperty(0);
        dynamicPrimitiveEager.changeProperty(-79);
        assertEquals(0, dynamicPrimitive.getInt());
        assertEquals(-79, dynamicPrimitiveEager.getInt());

        dynamicPrimitive.changeProperty(-99999999999999.);
        dynamicPrimitiveEager.changeProperty(10000000000000.);
        assertEquals(0, dynamicPrimitive.getInt());
        assertEquals(0, dynamicPrimitiveEager.getInt());

        dynamicPrimitive.changeProperty(1.73);
        dynamicPrimitiveEager.changeProperty(-98.9);
        assertEquals(1, dynamicPrimitive.getInt());
        assertEquals(-98, dynamicPrimitiveEager.getInt());
    }

    @org.junit.Test
    public void getShort() throws Exception {

    }

    @org.junit.Test
    public void getLong() throws Exception {

    }

    @org.junit.Test
    public void getFloat() throws Exception {

    }

    @org.junit.Test
    public void getDouble() throws Exception {

    }

    @org.junit.Test
    public void getChar() throws Exception {

    }

    @org.junit.Test
    public void getByte() throws Exception {

    }

}