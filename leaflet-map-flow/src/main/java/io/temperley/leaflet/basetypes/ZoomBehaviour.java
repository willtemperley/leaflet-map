package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.LeafletSerializable;

/**
 * This has the delightful type "Boolean|String" in Leaflet
 * Used to define zoom behaviour for several types of click
 */
public enum ZoomBehaviour implements LeafletSerializable {
    Enabled {
        @Override
        public Object serializable() {
            return true;
        }
    },
    Disabled {
        @Override
        public Object serializable() {
            return false;
        }
    },
    Centre {
        @Override
        public Object serializable() {
            return "center";
        }
    }


}

