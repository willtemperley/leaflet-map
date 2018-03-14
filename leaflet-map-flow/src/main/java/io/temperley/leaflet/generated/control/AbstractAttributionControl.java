package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-attribution-control")
@HtmlImport("bower_components/leaflet-map/leaflet-attribution-control.html")
public abstract class AbstractAttributionControl extends AbstractControl {
  /**
   * Creates an attribution control.
   */
  public AbstractAttributionControl(LeafletSerializable options) {
    List<Object> objects = new ArrayList<>();
    objects.add(options.serializable());
    setProperty("constructorargs", objects);
  }

  /**
   * Sets the text before the attributions.
   */
  public void setPrefix(String prefix) {
    List<Object> objects = new ArrayList<>();
    objects.add(prefix);
    setProperty("setPrefix", objects);
  }

  /**
   * Adds an attribution text (e.g. 'Vector data &copy; Mapbox').
   */
  public void addAttribution(String text) {
    List<Object> objects = new ArrayList<>();
    objects.add(text);
    setProperty("addAttribution", objects);
  }

  /**
   * Removes an attribution text.
   */
  public void removeAttribution(String text) {
    List<Object> objects = new ArrayList<>();
    objects.add(text);
    setProperty("removeAttribution", objects);
  }
}
