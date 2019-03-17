package io.temperley.leaflet.generated.ui;

import io.temperley.leaflet.basetypes.LeafletPoint;
import io.temperley.leaflet.generated.layer.AbstractLayerOptions;
import java.lang.String;

public abstract class AbstractDivoverlayOptions<T extends AbstractDivoverlayOptions<T>> extends AbstractLayerOptions<T> {
    /**
     * The offset of the popup position. Useful to control the anchor of the popup when opening it on some overlays.
     * default: Point(0, 7)
     */
    public T offset(LeafletPoint offset) {
        addOption("offset", offset);
        return this.get();
    }

    /**
     * A custom CSS class name to assign to the popup.
     * default: ''
     */
    public T className(String className) {
        addOption("className", className);
        return this.get();
    }

    /**
     * Map pane where the popup will be added.
     * default: 'popupPane'
     */
    public T pane(String pane) {
        addOption("pane", pane);
        return this.get();
    }
}
