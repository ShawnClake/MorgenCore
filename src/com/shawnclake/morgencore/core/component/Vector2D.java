package com.shawnclake.morgencore.core.component;

/**
 * 2 dimensional vector (x,y)
 */
public class Vector2D extends Vector1D {

    private float y;

    public Vector2D(float x, float y) {
        super(x);
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
