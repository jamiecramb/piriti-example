package org.test.piriti.shared;

/**
 * Representation of a Cat.
 * 
 * @author Jamie Cramb
 */
public class Cat extends AbstractNamedAnimal {

    private Boolean likesMice;

    public Cat() {
        super(null, null);
    }

    public Cat(Long id, String name, Boolean likesMice) {
        super(id, name);
        this.likesMice = likesMice;
    }

    public Boolean getLikesMice() {
        return likesMice;
    }

    public void setLikesMice(Boolean likesMice) {
        this.likesMice = likesMice;
    }

    @Override
    public String toString() {
        return "Cat [getId()=" + getId() + ", getName()=" + getName() + ", getCurrentEmotion()=" + getCurrentEmotion()
                + ", getLikesMice()=" + getLikesMice() + "]";
    }
}