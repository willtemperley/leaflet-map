package io.temperley.leaflet.generated.layer;

import io.temperley.leaflet.basetypes.Icon;
import io.temperley.leaflet.basetypes.LeafletPoint;
import java.lang.Boolean;
import java.lang.Number;
import java.lang.String;

public abstract class AbstractMarkerOptions<T extends AbstractMarkerOptions<T>> extends AbstractLayerOptions<T> {
    /**
     * Icon instance to use for rendering the marker. See Icon documentation for details on how to customize the marker icon. If not specified, a common instance of L.Icon.Default is used.
     * default: *
     */
    public T icon(Icon icon) {
        addOption("icon", icon);
        return this.get();
    }

    /**
     * Whether the marker is draggable with mouse/touch or not.
     * default: false
     */
    public T draggable(Boolean draggable) {
        addOption("draggable", draggable);
        return this.get();
    }

    /**
     * Set it to true if you want the map to do panning animation when marker hits the edges.
     * default: false
     */
    public T autoPan(Boolean autoPan) {
        addOption("autoPan", autoPan);
        return this.get();
    }

    /**
     * Equivalent of setting both top left and bottom right autopan padding to the same value.
     * default: Point(50, 50)
     */
    public T autoPanPadding(LeafletPoint autoPanPadding) {
        addOption("autoPanPadding", autoPanPadding);
        return this.get();
    }

    /**
     * Number of pixels the map should move by.
     * default: 10
     */
    public T autoPanSpeed(Number autoPanSpeed) {
        addOption("autoPanSpeed", autoPanSpeed);
        return this.get();
    }

    /**
     * Whether the marker can be tabbed to with a keyboard and clicked by pressing enter.
     * default: true
     */
    public T keyboard(Boolean keyboard) {
        addOption("keyboard", keyboard);
        return this.get();
    }

    /**
     * Text for the browser tooltip that appear on marker hover (no tooltip by default).
     * default: ''
     */
    public T title(String title) {
        addOption("title", title);
        return this.get();
    }

    /**
     * Text for the alt attribute of the icon image (useful for accessibility).
     * default: ''
     */
    public T alt(String alt) {
        addOption("alt", alt);
        return this.get();
    }

    /**
     * By default, marker images zIndex is set automatically based on its latitude. Use this option if you want to put the marker on top of all others (or below), specifying a high value like 1000 (or high negative value, respectively).
     * default: 0
     */
    public T zIndexOffset(Number zIndexOffset) {
        addOption("zIndexOffset", zIndexOffset);
        return this.get();
    }

    /**
     * The opacity of the marker.
     * default: 1.0
     */
    public T opacity(Number opacity) {
        addOption("opacity", opacity);
        return this.get();
    }

    /**
     * If true, the marker will get on top of others when you hover the mouse over it.
     * default: false
     */
    public T riseOnHover(Boolean riseOnHover) {
        addOption("riseOnHover", riseOnHover);
        return this.get();
    }

    /**
     * The z-index offset used for the riseOnHover feature.
     * default: 250
     */
    public T riseOffset(Number riseOffset) {
        addOption("riseOffset", riseOffset);
        return this.get();
    }

    /**
     * Map pane where the markers icon will be added.
     * default: 'markerPane'
     */
    public T pane(String pane) {
        addOption("pane", pane);
        return this.get();
    }

    /**
     * When true, a mouse event on this marker will trigger the same event on the map (unless L.DomEvent.stopPropagation is used).
     * default: false
     */
    public T bubblingMouseEvents(Boolean bubblingMouseEvents) {
        addOption("bubblingMouseEvents", bubblingMouseEvents);
        return this.get();
    }
}
