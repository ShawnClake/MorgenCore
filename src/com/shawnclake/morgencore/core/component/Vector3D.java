package com.shawnclake.morgencore.core.component;

/**
 * 3 dimensional vector (x,y,z)
 */
public class Vector3D extends Vector2D {

    private float z;

    public Vector3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
