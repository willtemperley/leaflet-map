package io.temperley.leaflet;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;
import io.temperley.leaflet.events.MapViewChangeEvent;

@Tag("leaflet-map")
@HtmlImport("frontend://bower_components/leaflet-map/leaflet-map.html")
public class LeafletMap extends Component implements HasComponents {

    public LeafletMap() {
    }

    public LeafletMap zoom(int zoom) {
        getElement().setProperty("zoom", zoom);
        return this;
    }

    public void setCentre(double x, double y) {
        getElement().setProperty("latitude", y);
        getElement().setProperty("longitude", x);
    }

    @Synchronize({"moveend", "zoomend", "dragend"})
    public String getMapState() {
        return getElement().getProperty("mapState", "");
    }

    public Registration addValueChangeListener(
            ComponentEventListener<MapViewChangeEvent> valueChangeListener) {
        return super.addListener(MapViewChangeEvent.class, valueChangeListener);
    }
}
