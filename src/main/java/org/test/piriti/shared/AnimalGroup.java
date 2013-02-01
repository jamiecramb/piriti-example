package org.test.piriti.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Groups animals into a collection so they can travel together
 * 
 * @author Jamie Cramb
 */
public class AnimalGroup {

    private List<AbstractNamedAnimal> animals;

    public AnimalGroup() {
        animals = new ArrayList<AbstractNamedAnimal>();
    }

    public void addAnimal(AbstractNamedAnimal animal) {
        animals.add(animal);
    }

    public void setAnimals(List<AbstractNamedAnimal> animals) {
        this.animals = animals;
    }

    public List<AbstractNamedAnimal> getAnimals() {
        return animals;
    }
}