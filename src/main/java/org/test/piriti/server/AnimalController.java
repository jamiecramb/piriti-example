package org.test.piriti.server;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.AnimalGroup;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.WildCat;

/**
 * Rest Controller to perform CRUD on {@link AnimalGroup}s.
 * 
 * @author Jamie Cramb
 */
@Controller
@RequestMapping("/")
public class AnimalController {

    private final AnimalGroup animalGroup;

    public AnimalController() {

        Long animalId = 0L;

        // Create a group to hold the animals
        animalGroup = new AnimalGroup();

        // Create 2 Dogs
        Dog snoopy = new Dog(animalId++, "snoopy", "Ball");
        snoopy.setCurrentEmotion("Happy");
        snoopy.setCurrentThought("Shiney");
        animalGroup.addAnimal(snoopy);

        Dog rover = new Dog(animalId++, "rover", "Stick");
        rover.setCurrentEmotion("Perplexed");
        rover.setCurrentThought("Squirrel!!!");
        animalGroup.addAnimal(rover);

        // Create a standard cat
        Cat fluffy = new Cat(animalId++, "fluffy", true);
        fluffy.setCurrentEmotion("Happy");
        animalGroup.addAnimal(fluffy);

        // Create a wild cat
        WildCat wildCat = new WildCat(animalId++, "wild cat");
        wildCat.setCurrentEmotion("Despondent");
        animalGroup.addAnimal(wildCat);

        // Create a standard cat
        Cat mrBigglesworth = new Cat(animalId++, "mr bigglesworth", false);
        mrBigglesworth.setCurrentEmotion("Anger");
        animalGroup.addAnimal(mrBigglesworth);
    }

    @RequestMapping(value = "animals", method = RequestMethod.GET)
    @ResponseBody
    public AnimalGroup getAnimals() {

        // Return the animal group
        return animalGroup;
    }

    @RequestMapping(value = "animals", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String saveAnimals(@RequestBody AnimalGroup animalGroup) {

        for (AbstractNamedAnimal currentAnimal : animalGroup.getAnimals()) {
            System.out.println("Animal sent from client: " + currentAnimal);
        }

        return "ok";
    }
}
