package io.temperley.leaflet;

import java.lang.Boolean;

public class ZoomOptions<T extends ZoomOptions<T>> extends OptionsBase<T> {
  /**
   * If not specified, zoom animation will happen if the zoom origin is inside the current view. If true, the map will attempt animating zoom disregarding where zoom origin is. Setting false will make it always reset the view completely without animation.
   * default: 
   */
  public ZoomOptions animate(Boolean animate) {
    addOption("animate", animate);
    return this.get();
  }
}
