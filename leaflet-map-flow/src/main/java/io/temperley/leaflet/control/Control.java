package io.temperley.leaflet.control;

import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.Object;
import java.lang.String;

public class Control extends TakesServerOptions {
  public Control(OptionsBase options) {
    super(options);
  }

  /**
   * Returns the position of the control.
   */
  public String getPosition() {
    return getElement().getProperty("position");
  }

  /**
   * Sets the position of the control.
   */
  public void setPosition(String position) {
    getElement().setProperty("position", position);
  }

  /**
   * Returns the HTMLElement that contains the control.
   */
  public Object getContainer() {
    return getElement().getProperty("container");
  }

  /**
   * Adds the control to the given map.
   */
  public void addTo() {
  }

  /**
   * Removes the control from the map it is currently active on.
   */
  public void remove() {
    getElement().removeFromParent();
  }
}
