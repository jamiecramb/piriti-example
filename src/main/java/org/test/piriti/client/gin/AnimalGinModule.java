package org.test.piriti.client.gin;

import org.test.piriti.client.json.JsonReaders.AbstractNamedAnimalJsonReader;
import org.test.piriti.client.json.JsonReaders.AnimalGroupJsonReader;
import org.test.piriti.client.json.JsonReaders.CatJsonReader;
import org.test.piriti.client.json.JsonReaders.DogJsonReader;
import org.test.piriti.client.json.JsonReaders.WildCatJsonReader;
import org.test.piriti.client.json.JsonWriters.AbstractNamedAnimalJsonWriter;
import org.test.piriti.client.json.JsonWriters.AnimalGroupJsonWriter;
import org.test.piriti.client.json.JsonWriters.CatJsonWriter;
import org.test.piriti.client.json.JsonWriters.DogJsonWriter;
import org.test.piriti.client.json.JsonWriters.WildCatJsonWriter;
import org.test.piriti.client.presenter.MainPresenter;
import org.test.piriti.client.presenter.MainPresenterImpl;
import org.test.piriti.client.presenter.view.MainView;
import org.test.piriti.client.presenter.view.MainViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class AnimalGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        // Bind the JSON readers as eager singletons
        bind(AbstractNamedAnimalJsonReader.class).asEagerSingleton();
        bind(AnimalGroupJsonReader.class).asEagerSingleton();
        bind(CatJsonReader.class).asEagerSingleton();
        bind(DogJsonReader.class).asEagerSingleton();
        bind(WildCatJsonReader.class).asEagerSingleton();

        // Bind the JSON writers as eager singletons
        bind(AbstractNamedAnimalJsonWriter.class).asEagerSingleton();
        bind(AnimalGroupJsonWriter.class).asEagerSingleton();
        bind(CatJsonWriter.class).asEagerSingleton();
        bind(DogJsonWriter.class).asEagerSingleton();
        bind(WildCatJsonWriter.class).asEagerSingleton();

        // Bind the view impl to the view interface & define the impl as a singleton; the instance will be lazily
        // created the first time it is required.
        bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);

        // Bind the presenter impl to the presenter contract but keep it out of the singleton scope so that it can be
        // created on-demand every time it is required.
        bind(MainPresenter.class).to(MainPresenterImpl.class);
    }
}