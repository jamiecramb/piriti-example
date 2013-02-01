package org.test.piriti.client.gin;

import org.test.piriti.client.json.JsonReaders.AnimalGroupJsonReader;
import org.test.piriti.client.json.JsonWriters.AnimalGroupJsonWriter;
import org.test.piriti.client.presenter.MainPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({
    AnimalGinModule.class
})
public interface AnimalGinInjector extends Ginjector {

    AnimalGroupJsonReader getAnimalGroupJsonReader();

    AnimalGroupJsonWriter getAnimalGroupJsonWriter();

    MainPresenter getMainPresenter();
}