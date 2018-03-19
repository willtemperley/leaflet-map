package io.temperley.leaflet.generated.layer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.basetypes.Popup;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-layer")
@HtmlImport("bower_components/leaflet-map/leaflet-layer.html")
public abstract class AbstractLayer extends TakesServerOptions {
    /**
     * Removes the layer from the map it is currently active on.
     */
    public void remove() {
        getElement().removeFromParent();
    }

    /**
     * Used by the attribution control, returns the attribution option.
     */
    public String getAttribution() {
        return getElement().getProperty("attribution");
    }

    /**
     * Binds a popup to the layer with the passed content and sets up the necessary event listeners. If a Function is passed it will receive the layer as the first argument and should return a String or HTMLElement.
     */
    public void bindPopup(LeafletSerializable content) {
        List<Object> objects = new ArrayList<>();
        objects.add(content.serializable());
        setProperty("bindPopup", objects);
    }

    /**
     * Binds a popup to the layer with the passed content and sets up the necessary event listeners. If a Function is passed it will receive the layer as the first argument and should return a String or HTMLElement.
     */
    public void bindPopup(LeafletSerializable content, LeafletSerializable options) {
        List<Object> objects = new ArrayList<>();
        objects.add(content.serializable());
        objects.add(options.serializable());
        setProperty("bindPopup", objects);
    }

    /**
     * the popup previously bound with bindPopup.
     */
    public void unbindPopup() {
        List<Object> objects = new ArrayList<>();
        setProperty("unbindPopup", objects);
    }

    /**
     * Opens the bound popup at the specified latlng or at the default popup anchor if no latlng is passed.
     */
    public void openPopup() {
        List<Object> objects = new ArrayList<>();
        setProperty("openPopup", objects);
    }

    /**
     * Opens the bound popup at the specified latlng or at the default popup anchor if no latlng is passed.
     */
    public void openPopup(LatLng latlng) {
        List<Object> objects = new ArrayList<>();
        objects.add(latlng.serializable());
        setProperty("openPopup", objects);
    }

    /**
     * Closes the popup bound to this layer if it is open.
     */
    public void closePopup() {
        List<Object> objects = new ArrayList<>();
        setProperty("closePopup", objects);
    }

    /**
     * Opens or closes the popup bound to this layer depending on its current state.
     */
    public void togglePopup() {
        List<Object> objects = new ArrayList<>();
        setProperty("togglePopup", objects);
    }

    /**
     * Returns true if the popup bound to this layer is currently open.
     */
    public void isPopupOpen() {
        List<Object> objects = new ArrayList<>();
        setProperty("isPopupOpen", objects);
    }

    /**
     * Sets the content of the popup bound to this layer.
     */
    public void setPopupContent(String content) {
        List<Object> objects = new ArrayList<>();
        objects.add(content);
        setProperty("setPopupContent", objects);
    }

    /**
     * Returns the popup bound to this layer.
     */
    public Popup getPopup() {
        String str = getElement().getProperty("popup");
        return Popup.fromString(str);
    }
}
