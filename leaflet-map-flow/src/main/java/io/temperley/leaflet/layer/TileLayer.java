package io.temperley.leaflet.layer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.options.TakesServerOptions;

@Tag("leaflet-tilelayer")
@HtmlImport("bower_components/leaflet-map/leaflet-layer.html")
public class TileLayer extends TakesServerOptions {

    public TileLayer(TileLayerOptions options) {
        super(options);
    }
}
