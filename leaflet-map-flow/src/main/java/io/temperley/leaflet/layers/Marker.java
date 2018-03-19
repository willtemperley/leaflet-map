package io.temperley.leaflet.layers;

import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.generated.layer.AbstractMarker;

public class Marker extends AbstractMarker {

    public Marker(LatLng latlng) {
        super(latlng);
    }

    public Marker(LatLng latlng, MarkerOptions options) {
        super(latlng, options);
    }

}
