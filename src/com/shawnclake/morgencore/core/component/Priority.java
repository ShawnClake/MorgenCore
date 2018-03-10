package com.shawnclake.morgencore.core.component;

/**
 * A Priority enumerator
 * Provides 5 priority levels: HIGH, ABOVE_NORMAL, NORMAL, BELOW_NORMAL, LOW
 */
public enum Priority {
    HIGH(5),
    ABOVE_NORMAL(4),
    NORMAL(3),
    BELOW_NORMAL(2),
    LOW(1);

    private final int priority;

    Priority(final int priority)
    {
        this.priority = priority;
    }

    /**
     * Returns the priority number as a string
     * eg. "5", "4", "1"
     * @return
     */
    @Override
    public String toString()
    {
        return String.valueOf(this.priority);
    }

    /**
     * Returns the priority number as an int
     * @return
     */
    public int toInt()
    {
        return this.priority;
    }

    /**
     * Returns a priority enum based on the given priority
     * 5: highest priority, 1: lowest priority
     * @param priority
     * @return
     */
    public static Priority fromInt(int priority)
    {
        for (Priority n : Priority.values()) {
            if (n.priority == priority) {
                return n;
            }
        }

        return NORMAL;
    }

    /**
     * Returns a priority enum based on the given priority string. "5", "4", "1" etc
     * 5: highest priority, 1: lowest priority
     * @param priority
     * @return
     */
    public static Priority fromString(String priority)
    {
        int p = Integer.parseInt(priority);
        for (Priority n : Priority.values()) {
            if (n.priority == p) {
                return n;
            }
        }

        return NORMAL;
    }

    /**
     * Returns whether the first priority is higher than the second.
     * @param priority
     * @param compare
     * @return
     */
    public boolean isHigher(Priority priority, Priority compare)
    {
        return priority.toInt() > compare.toInt();
    }

    /**
     * Returns whether the first priority is lower than the second.
     * @param priority
     * @param compare
     * @return
     */
    public boolean isLower(Priority priority, Priority compare)
    {
        return priority.toInt() < compare.toInt();
    }

    /**
     * Returns whether this priority is higher than a provided priority
     * @param compare
     * @return
     */
    public boolean isHigher(Priority compare )
    {
        return this.toInt() > compare.toInt();
    }

    /**
     * Returns whether this priority is lower than a provided priority
     * @param compare
     * @return
     */
    public boolean isLower(Priority compare)
    {
        return this.toInt() < compare.toInt();
    }
}
