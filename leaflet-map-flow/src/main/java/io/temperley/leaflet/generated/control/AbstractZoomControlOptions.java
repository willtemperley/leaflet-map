package io.temperley.leaflet.generated.control;

import java.lang.String;

public abstract class AbstractZoomControlOptions<T extends AbstractZoomControlOptions<T>> extends AbstractControlOptions<T> {
  /**
   * The text set on the 'zoom in' button.
   * default: '+'
   */
  public T zoomInText(String zoomInText) {
    addOption("zoomInText", zoomInText);
    return this.get();
  }

  /**
   * The title set on the 'zoom in' button.
   * default: 'Zoom in'
   */
  public T zoomInTitle(String zoomInTitle) {
    addOption("zoomInTitle", zoomInTitle);
    return this.get();
  }

  /**
   * ' The text set on the 'zoom out' button.
   * default: '&#x2212
   */
  public T zoomOutText(String zoomOutText) {
    addOption("zoomOutText", zoomOutText);
    return this.get();
  }

  /**
   * The title set on the 'zoom out' button.
   * default: 'Zoom out'
   */
  public T zoomOutTitle(String zoomOutTitle) {
    addOption("zoomOutTitle", zoomOutTitle);
    return this.get();
  }
}
