package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.LeafletSerializable;

//todo decide; purely use jts Point?
public class LatLngBounds implements LeafletSerializable {

    public LatLngBounds() {
    }

    @Override
    public Object serializable() {
        return null;
//        return new Double[][] {
//                new Double[] {
//                        40.712, -74.227,
//                },
//                new Double[] {
//                        40.774, -74.125
//                }
//        };
    }
}
