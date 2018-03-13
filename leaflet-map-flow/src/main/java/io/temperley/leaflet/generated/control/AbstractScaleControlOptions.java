package io.temperley.leaflet.generated.control;

import java.lang.Boolean;
import java.lang.Number;

public abstract class AbstractScaleControlOptions<T extends AbstractScaleControlOptions<T>> extends AbstractControlOptions<T> {
  /**
   * Maximum width of the control in pixels. The width is set dynamically to show round values (e.g. 100, 200, 500).
   * default: 100
   */
  public T maxWidth(Number maxWidth) {
    addOption("maxWidth", maxWidth);
    return this.get();
  }

  /**
   * Whether to show the metric scale line (m/km).
   * default: true
   */
  public T metric(Boolean metric) {
    addOption("metric", metric);
    return this.get();
  }

  /**
   * Whether to show the imperial scale line (mi/ft).
   * default: true
   */
  public T imperial(Boolean imperial) {
    addOption("imperial", imperial);
    return this.get();
  }

  /**
   * If true, the control is updated on moveend, otherwise it's always up-to-date (updated on move).
   * default: false
   */
  public T updateWhenIdle(Boolean updateWhenIdle) {
    addOption("updateWhenIdle", updateWhenIdle);
    return this.get();
  }
}
