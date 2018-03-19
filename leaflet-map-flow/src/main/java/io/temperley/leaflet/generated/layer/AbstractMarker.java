package io.temperley.leaflet.generated.layer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.basetypes.Icon;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.layers.MarkerOptions;
import java.lang.Number;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-marker")
@HtmlImport("bower_components/leaflet-map/leaflet-marker.html")
public abstract class AbstractMarker extends AbstractLayer {
    /**
     * Instantiates a Marker object given a geographical point and optionally an options object.
     */
    public AbstractMarker(LatLng latlng) {
        List<Object> objects = new ArrayList<>();
        objects.add(latlng.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Instantiates a Marker object given a geographical point and optionally an options object.
     */
    public AbstractMarker(LatLng latlng, MarkerOptions options) {
        List<Object> objects = new ArrayList<>();
        objects.add(latlng.serializable());
        objects.add(options.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Returns a GeoJSON representation of the marker (as a GeoJSON Point Feature).
     */
    public void toGeoJSON() {
        List<Object> objects = new ArrayList<>();
        setProperty("toGeoJSON", objects);
    }

    /**
     * Returns the current geographical position of the marker.
     */
    public LatLng getLatLng() {
        String str = getElement().getProperty("latlng");
        return LatLng.fromString(str);
    }

    /**
     * Changes the marker position to the given point.
     */
    public void setLatLng(LatLng latlng) {
        List<Object> objects = new ArrayList<>();
        objects.add(latlng.serializable());
        setProperty("setLatLng", objects);
    }

    /**
     * Changes the zIndex offset of the marker.
     */
    public void setZIndexOffset(Number offset) {
        List<Object> objects = new ArrayList<>();
        objects.add(offset);
        setProperty("setZIndexOffset", objects);
    }

    /**
     * Changes the marker icon.
     */
    public void setIcon(Icon icon) {
        List<Object> objects = new ArrayList<>();
        objects.add(icon.serializable());
        setProperty("setIcon", objects);
    }

    /**
     * Changes the opacity of the marker.
     */
    public void setOpacity(Number opacity) {
        List<Object> objects = new ArrayList<>();
        objects.add(opacity);
        setProperty("setOpacity", objects);
    }
}
