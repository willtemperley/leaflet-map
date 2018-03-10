package io.temperley.leaflet.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;

@Tag("leaflet-layers-control")
@HtmlImport("frontend://bower_components/leaflet-map/leaflet-layers-control.html")
public class LayersControl extends TakesServerOptions {
  public LayersControl(OptionsBase options) {
    super(options);
  }

  /**
   * Adds a base layer (radio button entry) with the given name to the control.
   */
  public void addBaseLayer() {
  }

  /**
   * Adds an overlay (checkbox entry) with the given name to the control.
   */
  public void addOverlay() {
  }

  /**
   * Remove the given layer from the control.
   */
  public void removeLayer() {
  }

  /**
   * Expand the control container if collapsed.
   */
  public void expand() {
  }

  /**
   * Collapse the control container if expanded.
   */
  public void collapse() {
  }
}
