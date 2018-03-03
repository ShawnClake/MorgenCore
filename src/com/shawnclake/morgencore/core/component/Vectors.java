package com.shawnclake.morgencore.core.component;

public class Vectors {

    public static float getDistance(Vector3D location1, Vector3D location2)
    {
        float x = location2.getX() - location1.getX();
        float y = location2.getY() - location1.getY();
        float z = location2.getZ() - location1.getZ();
        double total = Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2);
        return (float)Math.sqrt(total);
    }

    public static float getDistance(Vector2D location1, Vector2D location2)
    {
        float x = location2.getX() - location1.getX();
        float y = location2.getY() - location1.getY();
        double total = Math.pow(x, 2) + Math.pow(y, 2);
        return (float)Math.sqrt(total);
    }

    public static float getDistance(Vector1D location1, Vector1D location2)
    {
        float x = location2.getX() - location1.getX();
        return x;
    }

}
