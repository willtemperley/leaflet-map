package io.temperley.leaflet;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

@DomEvent("moveend")
public class MapViewChangeEvent extends ComponentEvent<LeafletMap> {

    public MapViewChangeEvent(LeafletMap source, boolean fromClient) {

        super(source, fromClient);

    }
}
