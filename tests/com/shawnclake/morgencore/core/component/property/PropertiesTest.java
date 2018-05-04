package com.shawnclake.morgencore.core.component.property;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesTest {

    @Test
    void __str__() {

        Properties properties = new Properties();
        properties.add("bob", new LazyDynamicPrimitive(5));
        properties.add("jimmy", new LazyDynamicPrimitive(true));
        properties.add("thenot", new LazyDynamicPrimitive(53476347773.));
        properties.add("huh", new LazyDynamicPrimitive("what in the world"));
        properties.add("noway", new LazyDynamicPrimitive('a'));

        System.out.println(properties.__str__());
        System.out.println(properties.__json__());

        properties.add("", new LazyDynamicPrimitive("crap"));
        properties.add(null, new LazyDynamicPrimitive('a'));
        properties.add("", null);
        properties.add(null, null);
        properties.add("what", null);

        System.out.println(properties.__str__());
        System.out.println(properties.__json__());
    }
}