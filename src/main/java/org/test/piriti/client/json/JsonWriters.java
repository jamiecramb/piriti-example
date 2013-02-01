package org.test.piriti.client.json;

import name.pehl.piriti.commons.client.Mapping;
import name.pehl.piriti.commons.client.Mappings;
import name.pehl.piriti.json.client.JsonWriter;

import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.AnimalGroup;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.SerializationConstants;
import org.test.piriti.shared.WildCat;

public interface JsonWriters {

    // AnimalGroup writer
    @Mappings({
        @Mapping(value = "animals", createWith = AnimalCreator.class)
    })
    public interface AnimalGroupJsonWriter extends JsonWriter<AnimalGroup> {
    }

    // Base class writer
    @Mappings({
            @Mapping("id"),
            @Mapping("name"),
            @Mapping(value = "SERIALIZATION_TYPE", path = SerializationConstants.TYPE_FIELD,
                    getter = SerializationTypePropertyGetter.class)
    })
    public interface AbstractNamedAnimalJsonWriter extends JsonWriter<AbstractNamedAnimal> {
    }

    // Cat writer
    @Mappings({
            @Mapping("likesMice"),
            @Mapping(value = "SERIALIZATION_TYPE", path = SerializationConstants.TYPE_FIELD,
                    getter = SerializationTypePropertyGetter.class)
    })
    public interface CatJsonWriter extends JsonWriter<Cat> {
    }

    // WildCat writer
    @Mappings({
        @Mapping(value = "SERIALIZATION_TYPE", path = SerializationConstants.TYPE_FIELD,
                getter = SerializationTypePropertyGetter.class)
    })
    public interface WildCatJsonWriter extends JsonWriter<WildCat> {
    }

    // Dog writer
    @Mappings({
            @Mapping("favouriteToy"),
            @Mapping(value = "SERIALIZATION_TYPE", path = SerializationConstants.TYPE_FIELD,
                    getter = SerializationTypePropertyGetter.class)
    })
    public interface DogJsonWriter extends JsonWriter<Dog> {
    }
}