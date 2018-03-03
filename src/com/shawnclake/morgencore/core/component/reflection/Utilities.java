package com.shawnclake.morgencore.core.component.reflection;

import java.lang.reflect.Field;

public class Utilities {

    /**
     * Set a specified Field accessible
     *
     * @author InventivetalentDev
     * @link https://github.com/InventivetalentDev/MenuBuilder/blob/master/src/main/java/org/inventivetalent/menubuilder/util/AccessUtil.java
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

}
