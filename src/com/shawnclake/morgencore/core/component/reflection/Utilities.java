package com.shawnclake.morgencore.core.component.reflection;

import java.lang.reflect.Field;

/**
 *
 */
public class Utilities {

    /**
     * Set a specified Field accessible
     *
     * @author InventivetalentDev
     * https://github.com/InventivetalentDev/MenuBuilder/blob/master/src/main/java/org/inventivetalent/menubuilder/util/AccessUtil.java
     *
     * @param f Field set accessible
     * @return <code>true</code> if the field was previously accessible
     */
    public static Field setAccessible(Field f) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        f.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(f, f.getModifiers() & 0xFFFFFFEF);
        return f;
    }

    /**
     * Returns true if the class passed implements the passed interface anywhere in the object chain
     *
     * @param clazz
     * @param theInterface
     * @return
     */
    public static boolean isObjectImplementing(Class<?> clazz, Object theInterface)
    {
        return theInterface.getClass().isAssignableFrom(clazz);
    }

    /**
     * Returns true if the object passed implements the passed interface anywhere in the object chain
     *
     * @param obj
     * @param theInterface
     * @return
     */
    public static boolean isObjectImplementing(Object obj, Object theInterface)
    {
        return theInterface.getClass().isAssignableFrom(obj.getClass());
    }

    /**
     * Returns true if the class passed implements the passed interface anywhere in the object chain
     *
     * @param clazz
     * @param theInterface
     * @return
     */
    public static boolean isObjectImplementing(Class<?> clazz, Class<?> theInterface)
    {
        return theInterface.isAssignableFrom(clazz);
    }

    /**
     * Returns true if the object passed implements the passed interface anywhere in the object chain
     *
     * @param obj
     * @param theInterface
     * @return
     */
    public static boolean isObjectImplementing(Object obj, Class<?> theInterface)
    {
        return theInterface.isAssignableFrom(obj.getClass());
    }





}
