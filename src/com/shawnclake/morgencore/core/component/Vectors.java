package com.shawnclake.morgencore.core.component;

/**
 * Helper vector functions
 */
public class Vectors {

    /**
     * Returns the distance between two vectors in the shortest straight line possible
     * 3D
     * @param location1
     * @param location2
     * @return
     */
    public static float getDistance(Vector3D location1, Vector3D location2)
    {
        float x = location2.getX() - location1.getX();
        float y = location2.getY() - location1.getY();
        float z = location2.getZ() - location1.getZ();
        double total = Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2);
        return (float)Math.sqrt(total);
    }

    /**
     * Returns the distance between two vectors in the shortest straight line possible
     * 2D
     * @param location1
     * @param location2
     * @return
     */
    public static float getDistance(Vector2D location1, Vector2D location2)
    {
        float x = location2.getX() - location1.getX();
        float y = location2.getY() - location1.getY();
        double total = Math.pow(x, 2) + Math.pow(y, 2);
        return (float)Math.sqrt(total);
    }

    /**
     * Returns the distance between two vectors in the shortest straight line possible
     * 1D
     * @param location1
     * @param location2
     * @return
     */
    public static float getDistance(Vector1D location1, Vector1D location2)
    {
        float x = location2.getX() - location1.getX();
        return x;
    }

}
