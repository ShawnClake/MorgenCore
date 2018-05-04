package com.shawnclake.morgencore.core.component.interactables;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.property.Properties;
import com.shawnclake.morgencore.core.component.services.ListService;

public class InteractableService extends ListService<Interactable> {

    @Override
    public String getDescription() {
        return "Types of input/output interactions with the application. ie. System, Account, Discord";
    }

    @Override
    public Properties getStateStatistics() {
        if(this.getItems().size() > 0)
        {
            String str = "";
            for(Interactable interactable : this.getItems())
            {
                str += interactable.__str__() + ", ";
            }
            return super.getStateStatistics().add("Types", new LazyDynamicPrimitive<>(str.substring(0, str.length() - 2)));
        } else {
            return super.getStateStatistics().add("Types", new LazyDynamicPrimitive<>("None"));
        }

    }
}
