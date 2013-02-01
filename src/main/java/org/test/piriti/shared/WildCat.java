package org.test.piriti.shared;

/**
 * Marker class to indicate this is a "wild cat" and not a pet cat. Wild cats don't like mice... too small to be worth
 * chasing...
 * 
 * @author Jamie Cramb
 */
public class WildCat extends Cat {

    public WildCat() {
        super();
    }

    public WildCat(Long id, String name) {
        super(id, name, false);
    }

    @Override
    public String toString() {
        return "WildCat [getId()=" + getId() + ", getName()=" + getName() + ", getCurrentEmotion()="
                + getCurrentEmotion() + ", getLikesMice()=" + getLikesMice() + "]";
    }
}