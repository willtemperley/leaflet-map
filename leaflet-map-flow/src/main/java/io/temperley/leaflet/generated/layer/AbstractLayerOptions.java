package io.temperley.leaflet.generated.layer;

import io.temperley.leaflet.options.OptionsBase;
import java.lang.Boolean;
import java.lang.String;

public abstract class AbstractLayerOptions<T extends AbstractLayerOptions<T>> extends OptionsBase<T> {
    /**
     * By default the layer will be added to the map's overlay pane. Overriding this option will cause the layer to be placed on another pane by default.
     * default: 'overlayPane'
     */
    public T pane(String pane) {
        addOption("pane", pane);
        return this.get();
    }

    /**
     * String to be shown in the attribution control, describes the layer data, e.g. "© Mapbox".
     * default: null
     */
    public T attribution(String attribution) {
        addOption("attribution", attribution);
        return this.get();
    }

    /**
     * If false, the layer will not emit mouse events and will act as a part of the underlying map.
     * default: true
     */
    public T interactive(Boolean interactive) {
        addOption("interactive", interactive);
        return this.get();
    }

    /**
     * When true, a mouse event on this layer will trigger the same event on the map (unless L.DomEvent.stopPropagation is used).
     * default: true
     */
    public T bubblingMouseEvents(Boolean bubblingMouseEvents) {
        addOption("bubblingMouseEvents", bubblingMouseEvents);
        return this.get();
    }
}
