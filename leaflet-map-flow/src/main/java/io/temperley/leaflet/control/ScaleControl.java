package io.temperley.leaflet.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("leaflet-scale-control")
@HtmlImport("frontend://bower_components/leaflet-map/leaflet-scale-control.html")
public class ScaleControl extends Control {

    public ScaleControl(ScaleControlOptions options) {
        super(options);
    }
}
