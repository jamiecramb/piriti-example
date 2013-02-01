package org.test.piriti.shared;

/**
 * A set of constants that can be used by Piriti & Jackson to correctly map polymorphic instances of classes.
 * 
 * @author Jamie Cramb
 */
public class SerializationConstants {

    /**
     * Note that this field must not include
     */
    public static final String TYPE_FIELD = "%type";

    /**
     * The value of the {@link #TYPE_FIELD} for a {@link Cat} object.
     */
    public static final String CAT = "Cat";

    /**
     * The value of the {@link #TYPE_FIELD} for a {@link WildCat} object.
     */
    public static final String WILD_CAT = "WildCat";

    /**
     * The value of the {@link #TYPE_FIELD} for a {@link Dog} object.
     */
    public static final String DOG = "Dog";

    // Hide the constructor
    private SerializationConstants() {
    }
}