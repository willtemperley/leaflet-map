package io.temperley.leaflet.control;

import java.lang.Boolean;
import java.lang.Object;

public class LayersControlOptions extends ControlOptions<LayersControlOptions> {
  /**
   * If true, the control will be collapsed into an icon and expanded on mouse hover or touch.
   * default: true
   */
  public LayersControlOptions collapsed(Boolean collapsed) {
    addOption("collapsed", collapsed);
    return this;
  }

  /**
   * If true, the control will assign zIndexes in increasing order to all of its layers so that the order is preserved when switching them on/off.
   * default: true
   */
  public LayersControlOptions autoZIndex(Boolean autoZIndex) {
    addOption("autoZIndex", autoZIndex);
    return this;
  }

  /**
   * If true, the base layers in the control will be hidden when there is only one.
   * default: false
   */
  public LayersControlOptions hideSingleBase(Boolean hideSingleBase) {
    addOption("hideSingleBase", hideSingleBase);
    return this;
  }

  /**
   * Whether to sort the layers. When false, layers will keep the order in which they were added to the control.
   * default: false
   */
  public LayersControlOptions sortLayers(Boolean sortLayers) {
    addOption("sortLayers", sortLayers);
    return this;
  }

  /**
   * A compare function that will be used for sorting the layers, when sortLayers is true. The function receives both the L.Layer instances and their names, as in sortFunction(layerA, layerB, nameA, nameB). By default, it sorts layers alphabetically by their name.
   * default: *
   */
  public LayersControlOptions sortFunction(Object sortFunction) {
    addOption("sortFunction", sortFunction);
    return this;
  }
}
