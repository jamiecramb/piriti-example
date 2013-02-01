package org.test.piriti.client.presenter;

import org.test.piriti.client.json.JsonReaders.AnimalGroupJsonReader;
import org.test.piriti.client.json.JsonWriters.AnimalGroupJsonWriter;
import org.test.piriti.client.view.MainView;
import org.test.piriti.shared.AbstractNamedAnimal;
import org.test.piriti.shared.AnimalGroup;
import org.test.piriti.shared.WildCat;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

    /**
     * Reference to the last downloaded animal group
     */
    private AnimalGroup lastAnimalGroup;

    /**
     * A reference to the view
     */
    private final MainView view;

    /**
     * A reference to the reader
     */
    private final AnimalGroupJsonReader animalGroupJsonReader;

    /**
     * A reference to the writer
     */
    private final AnimalGroupJsonWriter animalGroupJsonWriter;

    /**
     * Constructor.
     * 
     * @param view The view instance to be used.
     */
    @Inject
    public MainPresenterImpl(MainView view, AnimalGroupJsonReader animalGroupJsonReader,
            AnimalGroupJsonWriter animalGroupJsonWriter) {

        // Save a reference to the view
        this.view = view;

        // Save a reference to the reader / writer
        this.animalGroupJsonReader = animalGroupJsonReader;
        this.animalGroupJsonWriter = animalGroupJsonWriter;
    }

    @Override
    public void start() {
        // Let the view know we are now the controlling presenter
        view.setPresenter(this);
    }

    @Override
    public IsWidget getView() {
        return view.asWidget();
    }

    @Override
    public void onGetAnimals() {
        retrieveAnimals();
    }

    @Override
    public void onSendAnimals() {
        if (lastAnimalGroup == null) {
            view.setDownloadStatus("ERROR: You have to get animals before you can send them!");
            return;
        }

        sendAnimals(lastAnimalGroup);
    }

    private void retrieveAnimals() {
        try {

            String url = "resources/animals";

            RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

            builder.sendRequest("", new RequestCallback() {
                @Override
                public void onError(Request request, Throwable e) {
                    showRequestError(e, false);
                }

                @Override
                public void onResponseReceived(Request request, Response response) {
                    // Get the response text
                    String responseText = response.getText();
                    AnimalGroup animalGroup = animalGroupJsonReader.read(responseText);

                    // Save the animal group for sending later
                    lastAnimalGroup = animalGroup;

                    // Confirm that we have the animals
                    view.setDownloadStatus("true");

                    // Print out the animals
                    StringBuffer out = new StringBuffer();
                    for (AbstractNamedAnimal currentAnimal : animalGroup.getAnimals()) {
                        out.append("Animal Downloaded From Server: " + currentAnimal + "\r\n");
                    }
                    view.setDownloadStatus(out.toString());
                }
            });

        } catch (RequestException e) {
            showRequestError(e, false);
        }
    }

    private void sendAnimals(AnimalGroup animals) {

        // Add 1 more animal
        animals.addAnimal(new WildCat(9999L, "WildCat From Client"));

        try {

            String url = "resources/animals";
            String body = animalGroupJsonWriter.toJson(animals);

            RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
            builder.setHeader("Content-Type", "application/json");

            builder.sendRequest(body, new RequestCallback() {
                @Override
                public void onError(Request request, Throwable e) {
                    showRequestError(e, true);
                }

                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        view.setDownloadStatus("Request sent!");
                    } else {
                        view.setDownloadStatus("Something went wrong, server came back with response: "
                                + response.getStatusCode() + " - " + response.getText());
                    }
                }
            });

        } catch (RequestException e) {
            showRequestError(e, true);
        }
    }

    private void showRequestError(Throwable ex, boolean wasRetreiveAttemptFromServer) {
        view.setDownloadStatus("ERROR: while sending " + (wasRetreiveAttemptFromServer ? "GET" : "POST")
                + " request to server: " + ex.getMessage());
    }
}