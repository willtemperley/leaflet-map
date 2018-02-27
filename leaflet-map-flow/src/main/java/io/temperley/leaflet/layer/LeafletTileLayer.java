package io.temperley.leaflet.layer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentSupplier;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.TakesServerOptions;

@Tag("leaflet-tilelayer")
@HtmlImport("bower_components/leaflet-map/leaflet-layer.html")
public class LeafletTileLayer extends TakesServerOptions {

    public LeafletTileLayer(TileLayerOptions options) {
        super(options);
    }



}
