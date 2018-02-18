package io.temperley;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("leaflet-map")
@HtmlImport("bower_components/leaflet-map/leaflet-map.html")
public class LeafletMap extends Component {

    public LeafletMap() {
    }

    public LeafletMap(int zoom) {
        setZoom(zoom);
    }

    public void setZoom(int zoom) {
        getElement().setProperty("zoom", zoom);
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
