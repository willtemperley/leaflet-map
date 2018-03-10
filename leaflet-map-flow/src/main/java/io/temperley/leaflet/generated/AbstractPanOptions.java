package io.temperley.leaflet.generated;

import java.lang.Boolean;
import java.lang.Number;

public class AbstractPanOptions<T extends AbstractPanOptions<T>> extends AbstractZoomOptions<T> {
  /**
   * If true, panning will always be animated if possible. If false, it will not animate panning, either resetting the map view if panning more than a screen away, or just setting a new offset for the map pane (except for panBy which always does the latter).
   * default: 
   */
  public T animate(Boolean animate) {
    addOption("animate", animate);
    return this.get();
  }

  /**
   * Duration of animated panning, in seconds.
   * default: 0.25
   */
  public T duration(Number duration) {
    addOption("duration", duration);
    return this.get();
  }

  /**
   * The curvature factor of panning animation easing (third parameter of the Cubic Bezier curve). 1.0 means linear animation, and the smaller this number, the more bowed the curve.
   * default: 0.25
   */
  public T easeLinearity(Number easeLinearity) {
    addOption("easeLinearity", easeLinearity);
    return this.get();
  }

  /**
   * If true, panning won't fire movestart event on start (used internally for panning inertia).
   * default: false
   */
  public T noMoveStart(Boolean noMoveStart) {
    addOption("noMoveStart", noMoveStart);
    return this.get();
  }
}
