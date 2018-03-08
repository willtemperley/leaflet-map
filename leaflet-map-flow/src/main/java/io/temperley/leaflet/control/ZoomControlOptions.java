package io.temperley.leaflet.control;

import java.lang.String;

public class ZoomControlOptions extends ControlOptions<ZoomControlOptions> {
  /**
   * The text set on the 'zoom in' button.
   * default: '+'
   */
  public ZoomControlOptions zoomInText(String zoomInText) {
    addOption("zoomInText", zoomInText);
    return this;
  }

  /**
   * The title set on the 'zoom in' button.
   * default: 'Zoom in'
   */
  public ZoomControlOptions zoomInTitle(String zoomInTitle) {
    addOption("zoomInTitle", zoomInTitle);
    return this;
  }

  /**
   * ' The text set on the 'zoom out' button.
   * default: '&#x2212
   */
  public ZoomControlOptions zoomOutText(String zoomOutText) {
    addOption("zoomOutText", zoomOutText);
    return this;
  }

  /**
   * The title set on the 'zoom out' button.
   * default: 'Zoom out'
   */
  public ZoomControlOptions zoomOutTitle(String zoomOutTitle) {
    addOption("zoomOutTitle", zoomOutTitle);
    return this;
  }
}
