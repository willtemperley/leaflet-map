package io.temperley.leaflet.generated;

import io.temperley.leaflet.basetypes.LeafletPoint;
import java.lang.Number;

public abstract class AbstractFitBoundsOptions<T extends AbstractFitBoundsOptions<T>> extends AbstractPanOptions<T> {
    /**
     * Sets the amount of padding in the top left corner of a map container that shouldn't be accounted for when setting the view to fit bounds. Useful if you have some control overlays on the map like a sidebar and you don't want them to obscure objects you're zooming to.
     * default: [0, 0]
     */
    public T paddingTopLeft(LeafletPoint paddingTopLeft) {
        addOption("paddingTopLeft", paddingTopLeft);
        return this.get();
    }

    /**
     * The same for the bottom right corner of the map.
     * default: [0, 0]
     */
    public T paddingBottomRight(LeafletPoint paddingBottomRight) {
        addOption("paddingBottomRight", paddingBottomRight);
        return this.get();
    }

    /**
     * Equivalent of setting both top left and bottom right padding to the same value.
     * default: [0, 0]
     */
    public T padding(LeafletPoint padding) {
        addOption("padding", padding);
        return this.get();
    }

    /**
     * The maximum possible zoom to use.
     * default: null
     */
    public T maxZoom(Number maxZoom) {
        addOption("maxZoom", maxZoom);
        return this.get();
    }
}
