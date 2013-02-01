package org.test.piriti.client.presenter.view;

import org.test.piriti.client.presenter.MainPresenter;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Contract used by the presenter to speak to the view.
 * 
 * @author Jamie Cramb
 */
public interface MainView extends IsWidget {

    /**
     * Saves a reference to the presenter currently controlling the view.
     * 
     * @param presenter A reference to the presenter that's controlling the view
     */
    void setPresenter(MainPresenter presenter);

    /**
     * Set the download status on the screen.
     * 
     * @param status The download status represented as a string value.
     */
    void setDownloadStatus(String status);
}