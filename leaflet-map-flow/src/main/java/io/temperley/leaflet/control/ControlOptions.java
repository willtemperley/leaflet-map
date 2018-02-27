package io.temperley.leaflet.control;

import io.temperley.leaflet.OptionsBase;

public class ControlOptions<T> extends OptionsBase<T> {

    /**
     * The position of the control (one of the map corners). Possible values are 'topleft', 'topright', 'bottomleft' or 'bottomright'
     * default: 'topright'
     */
    public T position(String position) {
        addOption("position", position);
        return get();
    }
}
