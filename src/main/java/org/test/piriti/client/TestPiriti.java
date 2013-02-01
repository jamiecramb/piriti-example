package org.test.piriti.client;

import org.test.piriti.client.gin.AnimalGinInjector;
import org.test.piriti.client.presenter.MainPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main GWT application / test harness for the piriti test.
 * 
 * @author Jamie Cramb
 */
public class TestPiriti implements EntryPoint {

    @Override
    public void onModuleLoad() {

        // Create our GinInjector
        AnimalGinInjector injector = GWT.create(AnimalGinInjector.class);

        // Get a copy of the main presenter
        MainPresenter mainPresenter = injector.getMainPresenter();

        // Clear the root panel
        RootPanel.get().clear();

        // Get the view and add it to the root panel
        RootPanel.get().add(mainPresenter.getView());

        // Tell the presenter to start
        mainPresenter.start();
    }
}