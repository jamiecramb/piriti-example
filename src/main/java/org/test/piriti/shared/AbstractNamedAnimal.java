package org.test.piriti.shared;

/**
 * Base class for animals
 * 
 * @author Jamie Cramb
 */
public class AbstractNamedAnimal {

    private Long id;

    private String name;

    /**
     * Emotions are transient and shouldn't be serialised.
     */
    private String currentEmotion;

    /**
     * This property is just here to keep Piriti happy as it expects to find a valid field even when using a custom
     * {@link PropertyGetter}.
     * 
     * @deprecated This should be removed when Piriti is able to include type information as part of the serialisation
     *             process.
     */
    @Deprecated
    public static String SERIALIZATION_TYPE = "";

    public AbstractNamedAnimal() {
    }

    public AbstractNamedAnimal(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentEmotion() {
        return currentEmotion;
    }

    public void setCurrentEmotion(String currentEmotion) {
        this.currentEmotion = currentEmotion;
    }

    @Override
    public String toString() {
        return "AbstractNamedAnimal [getId()=" + getId() + ", getName()=" + getName() + ", getCurrentEmotion()="
                + getCurrentEmotion() + "]";
    }
}