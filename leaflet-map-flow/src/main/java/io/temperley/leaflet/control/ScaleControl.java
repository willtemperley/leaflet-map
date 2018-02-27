package io.temperley.leaflet.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.TakesServerOptions;

@Tag("leaflet-scale-control")
@HtmlImport("bower_components/leaflet-map/leaflet-scale-control.html")
public class ScaleControl extends TakesServerOptions {

    public ScaleControl(ScaleControlOptions options) {
        super(options);
    }
}
