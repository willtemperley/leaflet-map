package io.temperley.leaflet.events;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import io.temperley.leaflet.Map;

@DomEvent("moveend")
public class MapViewChangeEvent extends ComponentEvent<Map> {

    public MapViewChangeEvent(Map source, boolean fromClient) {

        super(source, fromClient);

    }
}
