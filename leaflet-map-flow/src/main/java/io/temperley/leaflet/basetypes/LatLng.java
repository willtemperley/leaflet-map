package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.LeafletSerializable;

public class LatLng implements LeafletSerializable {

    public final Double y;
    public final Double x;

    public LatLng(Double y, Double x) {
        this.y = y;
        this.x = x;
    }

    public Object serializable() {
        return new Double[] {y, x};
    }
}
