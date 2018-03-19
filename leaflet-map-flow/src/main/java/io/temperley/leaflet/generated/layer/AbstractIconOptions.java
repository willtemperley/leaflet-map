package io.temperley.leaflet.generated.layer;

import io.temperley.leaflet.basetypes.LeafletPoint;
import io.temperley.leaflet.options.OptionsBase;
import java.lang.String;

public abstract class AbstractIconOptions<T extends AbstractIconOptions<T>> extends OptionsBase<T> {
    /**
     * (required) The URL to the icon image (absolute or relative to your script path).
     * default: null
     */
    public T iconUrl(String iconUrl) {
        addOption("iconUrl", iconUrl);
        return this.get();
    }

    /**
     * The URL to a retina sized version of the icon image (absolute or relative to your script path). Used for Retina screen devices.
     * default: null
     */
    public T iconRetinaUrl(String iconRetinaUrl) {
        addOption("iconRetinaUrl", iconRetinaUrl);
        return this.get();
    }

    /**
     * Size of the icon image in pixels.
     * default: null
     */
    public T iconSize(LeafletPoint iconSize) {
        addOption("iconSize", iconSize);
        return this.get();
    }

    /**
     * The coordinates of the "tip" of the icon (relative to its top left corner). The icon will be aligned so that this point is at the marker's geographical location. Centered by default if size is specified, also can be set in CSS with negative margins.
     * default: null
     */
    public T iconAnchor(LeafletPoint iconAnchor) {
        addOption("iconAnchor", iconAnchor);
        return this.get();
    }

    /**
     * The coordinates of the point from which popups will "open", relative to the icon anchor.
     * default: [0, 0]
     */
    public T popupAnchor(LeafletPoint popupAnchor) {
        addOption("popupAnchor", popupAnchor);
        return this.get();
    }

    /**
     * The coordinates of the point from which tooltips will "open", relative to the icon anchor.
     * default: [0, 0]
     */
    public T tooltipAnchor(LeafletPoint tooltipAnchor) {
        addOption("tooltipAnchor", tooltipAnchor);
        return this.get();
    }

    /**
     * The URL to the icon shadow image. If not specified, no shadow image will be created.
     * default: null
     */
    public T shadowUrl(String shadowUrl) {
        addOption("shadowUrl", shadowUrl);
        return this.get();
    }

    /**
     * ""
     * default: null
     */
    public T shadowRetinaUrl(String shadowRetinaUrl) {
        addOption("shadowRetinaUrl", shadowRetinaUrl);
        return this.get();
    }

    /**
     * Size of the shadow image in pixels.
     * default: null
     */
    public T shadowSize(LeafletPoint shadowSize) {
        addOption("shadowSize", shadowSize);
        return this.get();
    }

    /**
     * The coordinates of the "tip" of the shadow (relative to its top left corner) (the same as iconAnchor if not specified).
     * default: null
     */
    public T shadowAnchor(LeafletPoint shadowAnchor) {
        addOption("shadowAnchor", shadowAnchor);
        return this.get();
    }

    /**
     * A custom class name to assign to both icon and shadow images. Empty by default.
     * default: ''
     */
    public T className(String className) {
        addOption("className", className);
        return this.get();
    }
}
