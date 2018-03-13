package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.LeafletSerializable;

public class LeafletPoint implements LeafletSerializable {

    private final double x;
    private final double y;

    public LeafletPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object serializable() {
        return new Double[] {
                x, y
        };
    }
}
