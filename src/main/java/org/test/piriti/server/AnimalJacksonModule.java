package org.test.piriti.server;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.Cat;
import org.test.piriti.shared.Dog;
import org.test.piriti.shared.SerializationConstants;
import org.test.piriti.shared.WildCat;

/**
 * A re-usable implementation of a Jackson {@link Module} that customises the (de)serialisation of objects for the
 * Animal object graph. This module needs to be registered with the {@link ObjectMapper} that will use it before it has
 * any effect.
 * 
 * @author Jamie Cramb
 */
public class AnimalJacksonModule extends Module {

    /**
     * Default constructor that delegates to super().
     */
    public AnimalJacksonModule() {
        super();
    }

    @Override
    public String getModuleName() {
        return "Animal Jackson Module";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, "");
    }

    /**
     * Registers the MixIns to customise the (de)serialisation of classes.
     * <hr/>
     * {@inheritDoc}
     */
    @Override
    public void setupModule(SetupContext context) {

        // Register MixIns for AbstractNamedAnimal and sub-classes
        registerMixIn(context, AbstractNamedAnimal.class, AbstractNamedAnimalMixIn.class);
        registerMixIn(context, Cat.class, CatMixIn.class);
        registerMixIn(context, WildCat.class, WildCatMixIn.class);
        registerMixIn(context, Dog.class, DogMixIn.class);
    }

    /**
     * Registers a MixIn for both serialisation and deserialisation.
     * 
     * @param context The SetupContext used to get the (De)Serialisation configs.
     * @param target The Class to apply the MixIn to.
     * @param mixinSource The MixIn to be applied.
     */
    private void registerMixIn(SetupContext context, Class<?> target, Class<?> mixinSource) {
        context.getSerializationConfig().addMixInAnnotations(target, mixinSource);
        context.getDeserializationConfig().addMixInAnnotations(target, mixinSource);
    }

    /**
     * MixIn for the {@link AbstractNamedAnimal} class that:
     * <ul>
     * <li>Specifies that type information should be stored for all serialised classes in a property called
     * {@link SerializationConstants#TYPE_FIELD}.</li>
     * <li>Identifies which sub-types are mappable back to the base class.</li>
     * <li>Ignores the {@link AbstractNamedAnimal#SERIALIZATION_TYPE} field as this is just there to keep Piriti happy.</li>
     * </ul>
     * 
     * @author Jamie Cramb
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
            property = SerializationConstants.TYPE_FIELD)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Cat.class, name = SerializationConstants.CAT),
            @JsonSubTypes.Type(value = WildCat.class, name = SerializationConstants.WILD_CAT),
            @JsonSubTypes.Type(value = Dog.class, name = SerializationConstants.DOG),
    })
    abstract class AbstractNamedAnimalMixIn {
        @JsonIgnore
        public String SERIALIZATION_TYPE = "";
    }

    /**
     * MixIn for the Cat class that customises the "TypeName" to use for the class when serialising from /
     * de-serialising to it.
     * 
     * @author Jamie Cramb
     */
    @JsonTypeName(SerializationConstants.CAT)
    abstract class CatMixIn {
    }

    /**
     * MixIn for the WildCat class that customises the "TypeName" to use for the class when serialising from /
     * de-serialising to it.
     * 
     * @author Jamie Cramb
     */
    @JsonTypeName(SerializationConstants.WILD_CAT)
    abstract class WildCatMixIn {
    }

    /**
     * MixIn for the Dog class that customises the "TypeName" to use for the class when serialising from /
     * de-serialising to it.
     * 
     * @author Jamie Cramb
     */
    @JsonTypeName(SerializationConstants.DOG)
    abstract class DogMixIn {
    }
}