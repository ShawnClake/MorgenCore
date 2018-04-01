package com.shawnclake.morgencore.core.component.objects.dynamic.primitives;

import com.shawnclake.morgencore.core.component.objects.PrimitiveTypes;

/**
 * Eager loads all conversions
 * Pros: No CPU usage when requesting a value
 * Cons: Large memory usage, Lots of CPU usage when preforming the loading
 *
 * todo: override __repr__ and __str__ where repr shows selections and status and str shows current values of the primitives
 */
public class EagerDynamicPrimitive<T> extends SelectiveEagerDynamicPrimitive<T> {

    public EagerDynamicPrimitive() {
        super(PrimitiveTypes.INTEGER,
                PrimitiveTypes.FLOAT,
                PrimitiveTypes.DOUBLE,
                PrimitiveTypes.LONG,
                PrimitiveTypes.SHORT,
                PrimitiveTypes.BYTE,
                PrimitiveTypes.CHAR,
                PrimitiveTypes.BOOLEAN
        );
    }

    public EagerDynamicPrimitive(T property) {
        super(property, PrimitiveTypes.INTEGER,
                PrimitiveTypes.FLOAT,
                PrimitiveTypes.DOUBLE,
                PrimitiveTypes.LONG,
                PrimitiveTypes.SHORT,
                PrimitiveTypes.BYTE,
                PrimitiveTypes.CHAR,
                PrimitiveTypes.BOOLEAN
        );
    }

}
