package io.temperley.leaflet.generated.control;

import java.lang.String;

public abstract class AbstractAttributionControlOptions<T extends AbstractAttributionControlOptions<T>> extends AbstractControlOptions<T> {
    /**
     * The HTML text shown before the attributions. Pass false to disable.
     * default: 'Leaflet'
     */
    public T prefix(String prefix) {
        addOption("prefix", prefix);
        return this.get();
    }
}
