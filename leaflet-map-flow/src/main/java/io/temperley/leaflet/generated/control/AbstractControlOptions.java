package io.temperley.leaflet.generated.control;

import io.temperley.leaflet.options.OptionsBase;
import java.lang.String;

public abstract class AbstractControlOptions<T extends AbstractControlOptions<T>> extends OptionsBase<T> {
  /**
   * The position of the control (one of the map corners). Possible values are 'topleft', 'topright', 'bottomleft' or 'bottomright'
   * default: 'topright'
   */
  public T position(String position) {
    addOption("position", position);
    return this.get();
  }
}
