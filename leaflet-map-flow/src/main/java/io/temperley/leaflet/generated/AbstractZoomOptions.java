package io.temperley.leaflet.generated;

import io.temperley.leaflet.OptionsBase;
import java.lang.Boolean;

public class AbstractZoomOptions<T extends AbstractZoomOptions<T>> extends OptionsBase<T> {
  /**
   * If not specified, zoom animation will happen if the zoom origin is inside the current view. If true, the map will attempt animating zoom disregarding where zoom origin is. Setting false will make it always reset the view completely without animation.
   * default: 
   */
  public T animate(Boolean animate) {
    addOption("animate", animate);
    return this.get();
  }
}
