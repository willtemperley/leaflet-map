package io.temperley.leaflet.generated.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.layers.Layer;
import io.temperley.leaflet.ui.PopupOptions;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-popup")
@HtmlImport("bower_components/leaflet-map/leaflet-popup.html")
public abstract class AbstractPopup extends AbstractDivoverlay {
    /**
     * Instantiates a Popup object given an optional options object that describes its appearance and location and an optional source object that is used to tag the popup with a reference to the Layer to which it refers.
     */
    public AbstractPopup() {
        List<Object> objects = new ArrayList<>();
        setProperty("constructorargs", objects);
    }

    /**
     * Instantiates a Popup object given an optional options object that describes its appearance and location and an optional source object that is used to tag the popup with a reference to the Layer to which it refers.
     */
    public AbstractPopup(PopupOptions options) {
        List<Object> objects = new ArrayList<>();
        objects.add(options.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Instantiates a Popup object given an optional options object that describes its appearance and location and an optional source object that is used to tag the popup with a reference to the Layer to which it refers.
     */
    public AbstractPopup(PopupOptions options, Layer source) {
        List<Object> objects = new ArrayList<>();
        objects.add(options.serializable());
        objects.add(source.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Returns the geographical point of popup.
     */
    public LatLng getLatLng() {
        String str = getElement().getProperty("latlng");
        return LatLng.fromString(str);
    }

    /**
     * Sets the geographical point where the popup will open.
     */
    public void setLatLng(LatLng latlng) {
        List<Object> objects = new ArrayList<>();
        objects.add(latlng.serializable());
        setProperty("setLatLng", objects);
    }

    /**
     * Returns the content of the popup.
     */
    public String getContent() {
        return getElement().getProperty("content");
    }

    /**
     * Sets the HTML content of the popup. If a function is passed the source layer will be passed to the function. The function should return a String or HTMLElement to be used in the popup.
     */
    public void setContent(String htmlContent) {
        List<Object> objects = new ArrayList<>();
        objects.add(htmlContent);
        setProperty("setContent", objects);
    }

    /**
     * Updates the popup content, layout and position. Useful for updating the popup after something inside changed, e.g. image loaded.
     */
    public void update() {
        List<Object> objects = new ArrayList<>();
        setProperty("update", objects);
    }

    /**
     * Returns true when the popup is visible on the map.
     */
    public void isOpen() {
        List<Object> objects = new ArrayList<>();
        setProperty("isOpen", objects);
    }

    /**
     * Brings this popup in front of other popups (in the same map pane).
     */
    public void bringToFront() {
        List<Object> objects = new ArrayList<>();
        setProperty("bringToFront", objects);
    }

    /**
     * Brings this popup to the back of other popups (in the same map pane).
     */
    public void bringToBack() {
        List<Object> objects = new ArrayList<>();
        setProperty("bringToBack", objects);
    }

    /**
     * Adds the popup to the map and closes the previous one. The same as map.openPopup(popup).
     */
    public void openOn(LeafletSerializable map) {
        List<Object> objects = new ArrayList<>();
        objects.add(map.serializable());
        setProperty("openOn", objects);
    }
}
