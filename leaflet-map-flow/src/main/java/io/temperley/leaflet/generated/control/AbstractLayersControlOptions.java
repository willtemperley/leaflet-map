package io.temperley.leaflet.generated.control;

import io.temperley.leaflet.LeafletSerializable;
import java.lang.Boolean;

public abstract class AbstractLayersControlOptions<T extends AbstractLayersControlOptions<T>> extends AbstractControlOptions<T> {
    /**
     * If true, the control will be collapsed into an icon and expanded on mouse hover or touch.
     * default: true
     */
    public T collapsed(Boolean collapsed) {
        addOption("collapsed", collapsed);
        return this.get();
    }

    /**
     * If true, the control will assign zIndexes in increasing order to all of its layers so that the order is preserved when switching them on/off.
     * default: true
     */
    public T autoZIndex(Boolean autoZIndex) {
        addOption("autoZIndex", autoZIndex);
        return this.get();
    }

    /**
     * If true, the base layers in the control will be hidden when there is only one.
     * default: false
     */
    public T hideSingleBase(Boolean hideSingleBase) {
        addOption("hideSingleBase", hideSingleBase);
        return this.get();
    }

    /**
     * Whether to sort the layers. When false, layers will keep the order in which they were added to the control.
     * default: false
     */
    public T sortLayers(Boolean sortLayers) {
        addOption("sortLayers", sortLayers);
        return this.get();
    }

    /**
     * A compare function that will be used for sorting the layers, when sortLayers is true. The function receives both the L.Layer instances and their names, as in sortFunction(layerA, layerB, nameA, nameB). By default, it sorts layers alphabetically by their name.
     * default: *
     */
    public T sortFunction(LeafletSerializable sortFunction) {
        addOption("sortFunction", sortFunction);
        return this.get();
    }
}
