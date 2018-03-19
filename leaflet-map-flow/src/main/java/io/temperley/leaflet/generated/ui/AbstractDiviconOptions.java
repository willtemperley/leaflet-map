package io.temperley.leaflet.generated.ui;

import io.temperley.leaflet.basetypes.LeafletPoint;
import java.lang.String;

public abstract class AbstractDiviconOptions<T extends AbstractDiviconOptions<T>> extends AbstractIconOptions<T> {
    /**
     * Custom HTML code to put inside the div element, empty by default.
     * default: ''
     */
    public T html(String html) {
        addOption("html", html);
        return this.get();
    }

    /**
     * Optional relative position of the background, in pixels
     * default: [0, 0]
     */
    public T bgPos(LeafletPoint bgPos) {
        addOption("bgPos", bgPos);
        return this.get();
    }
}
