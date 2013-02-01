package org.test.piriti.client.presenter;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contract used by the view / the main app to control and communicate with the presenter.
 * 
 * @author Jamie Cramb
 */
public interface MainPresenter {

    /**
     * Start the presenters processing of events etc.
     */
    void start();

    /**
     * Gets the view associated with the presenter.
     * 
     * @return The view.
     */
    IsWidget getView();

    /**
     * Handles a request from the view to get animals.
     */
    void onGetAnimals();

    /**
     * Handles a request from the view to send animals.
     */
    void onSendAnimals();
}