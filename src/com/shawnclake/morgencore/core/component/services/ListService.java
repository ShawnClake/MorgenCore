package com.shawnclake.morgencore.core.component.services;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.property.Properties;

import java.util.ArrayList;

abstract public class ListService<T> extends Service {

    private ArrayList<T> items = new ArrayList<>();

    public void add(T item)
    {
        if(contains(item.getClass()))
            return;
        items.add(item);
    }

    public boolean contains(Class item)
    {
        for(T theItem : items)
        {
            if(theItem.getClass() == item)
                return true;
        }

        return false;
    }

    public ArrayList<T> getItems()
    {
        return items;
    }

    public T getItem(Class<? extends T> itemClass)
    {
        for(T item : items)
        {
            if(item.getClass() == itemClass)
                return item;
        }

        return null;
    }

    @Override
    public String getDescription() {
        return "This list service has no description";
    }

    @Override
    public Properties getStateStatistics() {
        return new Properties().add("Size", new LazyDynamicPrimitive<>(this.items.size()));
    }
}
