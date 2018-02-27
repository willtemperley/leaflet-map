package io.temperley.leaflet.control;

import java.lang.Boolean;
import java.lang.Number;
import java.lang.String;

public class ScaleControlOptions extends ControlOptions<ScaleControlOptions> {
  /**
   * Maximum width of the control in pixels. The width is set dynamically to show round values (e.g. 100, 200, 500).
   * default: 100
   */
  public ScaleControlOptions maxWidth(Number maxWidth) {
    addOption("maxWidth", maxWidth);
    return this;
  }

  /**
   * Whether to show the metric scale line (m/km).
   * default: true
   */
  public ScaleControlOptions metric(Boolean metric) {
    addOption("metric", metric);
    return this;
  }

  /**
   * Whether to show the imperial scale line (mi/ft).
   * default: true
   */
  public ScaleControlOptions imperial(Boolean imperial) {
    addOption("imperial", imperial);
    return this;
  }

  /**
   * If true, the control is updated on moveend, otherwise it's always up-to-date (updated on move).
   * default: false
   */
  public ScaleControlOptions updateWhenIdle(Boolean updateWhenIdle) {
    addOption("updateWhenIdle", updateWhenIdle);
    return this;
  }

}
