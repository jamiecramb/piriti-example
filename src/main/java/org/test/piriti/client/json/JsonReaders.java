package org.test.piriti.client.json;

import name.pehl.piriti.commons.client.Mapping;
import name.pehl.piriti.commons.client.Mappings;
import name.pehl.piriti.json.client.JsonReader;

import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.AnimalGroup;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.WildCat;

public interface JsonReaders {

    // AnimalGroup reader
    @Mappings({
        @Mapping(value = "animals", createWith = AnimalCreator.class)
    })
    public interface AnimalGroupJsonReader extends JsonReader<AnimalGroup> {
    }

    // Base class reader
    @Mappings({
            @Mapping("id"), @Mapping("name")
    })
    public interface AbstractNamedAnimalJsonReader extends JsonReader<AbstractNamedAnimal> {
    }

    // Cat reader
    @Mappings({
        @Mapping("likesMice")
    })
    public interface CatJsonReader extends JsonReader<Cat> {
    }

    // WildCat reader
    public interface WildCatJsonReader extends JsonReader<WildCat> {
    }

    // Dog reader
    @Mappings({
        @Mapping("favouriteToy")
    })
    public interface DogJsonReader extends JsonReader<Dog> {
    }
}