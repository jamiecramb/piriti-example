package org.test.piriti.shared;

/**
 * Representation of a Dog
 * 
 * @author Jamie Cramb
 */
public class Dog extends AbstractNamedAnimal {

    private String favouriteToy;

    /**
     * Thoughts are transient and shouldn't be serialised.
     */
    private String currentThought;

    public Dog() {
        super(null, null);
    }

    public Dog(Long id, String name, String favouriteToy) {
        super(id, name);
        this.favouriteToy = favouriteToy;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }

    public String getCurrentThought() {
        return currentThought;
    }

    public void setCurrentThought(String currentThought) {
        this.currentThought = currentThought;
    }

    @Override
    public String toString() {
        return "Dog [getId()=" + getId() + ", getName()=" + getName() + ", getCurrentEmotion()=" + getCurrentEmotion()
                + ", getFavouriteToy()=" + getFavouriteToy() + ", getCurrentThought()=" + getCurrentThought() + "]";
    }
}