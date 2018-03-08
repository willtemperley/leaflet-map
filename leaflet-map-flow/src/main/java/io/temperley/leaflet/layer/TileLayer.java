package io.temperley.leaflet.layer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentSupplier;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.OptionsBase;
import io.temperley.leaflet.TakesServerOptions;

@Tag("leaflet-tilelayer")
@HtmlImport("bower_components/leaflet-map/leaflet-layer.html")
public class TileLayer extends TakesServerOptions {

    public TileLayer(TileLayerOptions options) {
        super(options);
    }
}
