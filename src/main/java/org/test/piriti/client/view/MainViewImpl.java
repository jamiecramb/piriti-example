package org.test.piriti.client.view;

import org.test.piriti.client.presenter.MainPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * Implementation of the view.
 * 
 * @author Jamie Cramb
 */
public class MainViewImpl extends Composite implements MainView {

    /**
     * UiBinder definition & instance.
     */
    interface MyViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
    }

    private static MyViewImplUiBinder uiBinder = GWT.create(MyViewImplUiBinder.class);

    /**
     * Reference to the main presenter that is currently controlling the view.
     */
    private MainPresenter presenter;

    /**
     * Button References
     */
    @UiField
    Button btnGetAnimals;

    @UiField
    Button btnSendAnimals;

    /**
     * Download status label references
     */
    @UiField
    TextArea txtDownloadStatus;

    /**
     * Constructor that sets up the view.
     */
    public MainViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * Handle "Get Animals" button click
     * 
     * @param e The click event.
     */
    @UiHandler("btnGetAnimals")
    void onGetAnimalsClick(ClickEvent e) {
        presenter.onGetAnimals();
    }

    /**
     * Handle "Send Animals" button click
     * 
     * @param e The click event.
     */
    @UiHandler("btnSendAnimals")
    void onSendAnimalsClick(ClickEvent e) {
        presenter.onSendAnimals();
    }

    @Override
    public void setDownloadStatus(String status) {
        txtDownloadStatus.setText(status);
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }
}