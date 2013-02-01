package org.test.piriti.client.json;

import name.pehl.piriti.json.client.JsonInstanceCreator;

import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.AnimalGroup;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.SerializationConstants;
import org.test.piriti.shared.WildCat;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.ncr.nep.connections.common.validation.Check;

/**
 * Creates an instance of the correct animal based on the {@link SerializationConstants#TYPE_FIELD} field. This class is
 * used by the JSON readers during de-serialisation in order to de-serialise the polymorphic set of objects
 * {@link AnimalGroup#animals}.
 * 
 * @author Jamie Cramb
 */
public class AnimalCreator extends JsonInstanceCreator<AbstractNamedAnimal> {

    /**
     * Creates a new object instance of an animal that is approirate for the current JSON document and returns it.
     * Returns null if no valid ype {@inheritDoc}
     */
    @Override
    public AbstractNamedAnimal newInstance(JSONValue context) {

        // Verify the response is a JSON object
        JSONObject jsonObject = context.isObject();

        // Verify the type field exists and is valid
        JSONValue typeJsonObject = jsonObject.get(SerializationConstants.TYPE_FIELD);

        Check.notNull(typeJsonObject, "'" + SerializationConstants.TYPE_FIELD
                + "' field was not present in JSON document.");

        // Try to get a JSON String from the field
        JSONString typeString = typeJsonObject.isString();

        // Verify the typeString is valid
        if (typeString == null || typeString.stringValue() == null || typeString.stringValue().trim().isEmpty()) {
            // Type field is invalid so throw an IllegalArumentException
            throw new IllegalArgumentException("'" + SerializationConstants.TYPE_FIELD
                    + "' field was missing or empty.");
        }

        // Create an animal based on the SerializationConstants.TYPE_FIELD value
        AbstractNamedAnimal animal = null;

        // Get the type
        String type = typeString.stringValue();

        // Create the correct type of class
        if (type.equals(SerializationConstants.CAT)) {
            animal = new Cat();
        } else if (type.equals(SerializationConstants.WILD_CAT)) {
            animal = new WildCat();
        } else if (type.equals(SerializationConstants.DOG)) {
            animal = new Dog();
        }

        // Verify we found an animal
        if (animal == null) {
            // We didn't find an animal
            throw new IllegalArgumentException("'" + SerializationConstants.TYPE_FIELD
                    + "' field was found but no valid animal could be created due to unknown type: " + type + ".");
        }

        // Return the empty animal object so piriti can populate it
        return animal;
    }
}