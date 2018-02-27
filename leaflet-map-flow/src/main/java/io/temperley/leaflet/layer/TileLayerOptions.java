package io.temperley.leaflet.layer;

import io.temperley.leaflet.OptionsBase;

/*
Simply generate all options and send as JSON
 */
public class TileLayerOptions extends OptionsBase {

    public TileLayerOptions(String url) {
        addOption("url", url);
    }

    public TileLayerOptions attribution(String attribution) {
        addOption("attribution", attribution);
        return this;
    }

}
