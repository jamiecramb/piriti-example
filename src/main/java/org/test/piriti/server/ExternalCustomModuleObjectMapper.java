package org.test.piriti.server;

import java.util.List;

import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.Assert;

/**
 * Extends the Jackson {@link ObjectMapper} in order to allow for the registration of custom {@link Module}s via spring
 * configuration.
 * 
 * @author Jamie Cramb
 */
public class ExternalCustomModuleObjectMapper extends ObjectMapper {

    /**
     * Default constructor that delegates to {@link ObjectMapper#ObjectMapper()}.
     */
    public ExternalCustomModuleObjectMapper() {
        super();
    }

    /**
     * Registers a set of custom modules with the {@link ObjectMapper} base class.
     * 
     * @param customModules The custom modules to register.
     * @throws IllegalArgumentException if the customModules collection is null.
     */
    public void setCustomModules(List<Module> customModules) {

        // Verify the params
        Assert.notNull(customModules, "The set of customModules to register cannot be null!");

        // Register the custom modules
        for (Module currentModule : customModules) {
            registerModule(currentModule);
        }
    }
}