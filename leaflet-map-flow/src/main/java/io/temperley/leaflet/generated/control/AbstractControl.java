package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-control")
@HtmlImport("bower_components/leaflet-map/leaflet-control.html")
public abstract class AbstractControl extends TakesServerOptions {
  public AbstractControl(OptionsBase options) {
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
    List<Object> objects = new ArrayList<>();
    objects.add(position);
    setProperty("setPosition", objects);
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
  public void addTo(Object map) {
    throw new RuntimeException("Not implemented. Use add() method on element.");
  }

  /**
   * Removes the control from the map it is currently active on.
   */
  public void remove() {
    getElement().removeFromParent();
  }
}
