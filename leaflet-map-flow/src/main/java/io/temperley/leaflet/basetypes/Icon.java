package io.temperley.leaflet.basetypes;

import io.temperley.leaflet.generated.layer.AbstractIconOptions;

/**
 * As a departure from the normal API, the Icon class is considered just an options object.
 */
public class Icon extends AbstractIconOptions<Icon> {

    /**
     * Create an Icon as an options object
     *
     * @param iconUrl required options
     */
    public Icon(String iconUrl) {
        addOption("iconUrl", iconUrl);
    }
}
