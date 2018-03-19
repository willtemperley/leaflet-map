package io.temperley.leaflet.basetypes;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import io.temperley.leaflet.LeafletSerializable;

public class LatLng implements LeafletSerializable {

    public final Double y;
    public final Double x;

    public LatLng(Double y, Double x) {
        this.y = y;
        this.x = x;
    }

    public static LatLng fromString(String json) {
        Any any = JsonIterator.deserialize(json);
        return new LatLng(any.get("y").toDouble(), any.get("x").toDouble());
    }

    public Object serializable() {
        return new Double[] {y, x};
    }
}
