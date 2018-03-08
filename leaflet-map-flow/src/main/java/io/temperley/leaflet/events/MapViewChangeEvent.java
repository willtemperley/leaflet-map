package io.temperley.leaflet.events;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import io.temperley.leaflet.LeafletMap;

@DomEvent("moveend")
public class MapViewChangeEvent extends ComponentEvent<LeafletMap> {

    public MapViewChangeEvent(LeafletMap source, boolean fromClient) {

        super(source, fromClient);

    }
}
