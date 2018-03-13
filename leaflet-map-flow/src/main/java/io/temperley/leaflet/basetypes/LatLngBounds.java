package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.LeafletSerializable;

public class LatLngBounds implements LeafletSerializable {
    private final LatLng corner1;
    private final LatLng corner2;

    public LatLngBounds(LatLng corner1, LatLng corner2) {

        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    @Override
    public Object serializable() {
        return new Double[][] {
                (Double[]) corner1.serializable(),
                (Double[]) corner2.serializable()
        };
    }
}
