package org.test.piriti.client.json;

import name.pehl.piriti.property.client.PropertyGetter;

import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.SerializationConstants;
import org.test.piriti.shared.WildCat;

/**
 * A custom PropertyGetter for Piriti that provides the value for the {@link SerializationConstants#TYPE_FIELD} when
 * serialising the Animal object graph.
 * 
 * @author Jamie Cramb
 */
public class SerializationTypePropertyGetter implements PropertyGetter<AbstractNamedAnimal, String> {

    @Override
    public String get(AbstractNamedAnimal model) {
        // Need to watch the ordering here so that sub-types are the highest... e.g. WildCat is an instance of WildCat
        // and Cat
        if (model instanceof WildCat) {
            return SerializationConstants.WILD_CAT;
        } else if (model instanceof Cat) {
            return SerializationConstants.CAT;
        } else if (model instanceof Dog) {
            return SerializationConstants.DOG;
        }

        return "Invalid type created on client: " + model.getClass().getName();
    }
}