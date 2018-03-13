package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.options.OptionsBase;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-layers-control")
@HtmlImport("bower_components/leaflet-map/leaflet-layers-control.html")
public abstract class AbstractLayersControl extends AbstractControl {
  public AbstractLayersControl(OptionsBase options) {
    super(options);
  }

  /**
   * Adds a base layer (radio button entry) with the given name to the control.
   */
  public void addBaseLayer(Object layer, String name) {
    List<Object> objects = new ArrayList<>();
//    objects.add(layer.serializable());
    objects.add(name);
    setProperty("addBaseLayer", objects);
  }

  /**
   * Adds an overlay (checkbox entry) with the given name to the control.
   */
  public void addOverlay(Object layer, String name) {
    List<Object> objects = new ArrayList<>();
//    objects.add(layer.serializable());
    objects.add(name);
    setProperty("addOverlay", objects);
  }

  /**
   * Remove the given layer from the control.
   */
  public void removeLayer(Object layer) {
    List<Object> objects = new ArrayList<>();
//    objects.add(layer.serializable());
    setProperty("removeLayer", objects);
  }

  /**
   * Expand the control container if collapsed.
   */
  public void expand() {
    List<Object> objects = new ArrayList<>();
    setProperty("expand", objects);
  }

  /**
   * Collapse the control container if expanded.
   */
  public void collapse() {
    List<Object> objects = new ArrayList<>();
    setProperty("collapse", objects);
  }
}
