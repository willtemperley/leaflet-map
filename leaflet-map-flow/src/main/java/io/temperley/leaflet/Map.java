package io.temperley.leaflet;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.basetypes.Bounds;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.basetypes.LatLngBounds;
import io.temperley.leaflet.basetypes.LeafletPoint;
import io.temperley.leaflet.generated.AbstractFitBoundsOptions;
import io.temperley.leaflet.generated.AbstractPanOptions;
import io.temperley.leaflet.generated.AbstractZoomOptions;
import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;

import java.lang.Boolean;
import java.lang.Number;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-map")
@HtmlImport("bower_components/leaflet-map/leaflet-map.html")
public class Map extends TakesServerOptions {
  public Map(OptionsBase options) {
    super(options);
  }

  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public void setView(LatLng center, Number zoom, AbstractPanOptions optionsOptional) {

    String methodName = "setView";
    List<Object> objects = new ArrayList<>();
    objects.add(center.serializable());
    objects.add(zoom);
    objects.add(optionsOptional.serializable());

    setProperty(methodName, objects);
  }

  /**
   * Sets the zoom of the map.
   */
  public void setZoom(Number zoom, AbstractPanOptions optionsOptional) {
    setProperty("zoom", zoom);
    setProperty("optionsOptional", optionsOptional);
  }

  /**
   * Increases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomIn(Number deltaOptional, AbstractZoomOptions optionsOptional) {
  }

  /**
   * Decreases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomOut(Number deltaOptional, AbstractZoomOptions optionsOptional) {
  }

  /**
   * Zooms the map while keeping a specified geographical point on the map stationary (e.g. used internally for scroll zoom and double-click zoom).
   */
  public void setZoomAround(LatLng latlng, Number zoom, AbstractZoomOptions options) {
    setProperty("latlng", latlng);
    setProperty("zoom", zoom);
    setProperty("options", options);
  }

  /**
   * Zooms the map while keeping a specified pixel on the map (relative to the top-left corner) stationary.
   */
  public void setZoomAround(LeafletPoint offset, Number zoom, AbstractZoomOptions options) {
    setProperty("offset", offset);
    setProperty("zoom", zoom);
    setProperty("options", options);
  }

  /**
   * Sets a map view that contains the given geographical bounds with the maximum zoom level possible.
   */
  public void fitBounds(LatLngBounds bounds, AbstractFitBoundsOptions optionsOptional) {
  }

  /**
   * Sets a map view that mostly contains the whole world with the maximum zoom level possible.
   */
  public void fitWorld(AbstractFitBoundsOptions optionsOptional) {
  }

  /**
   * Pans the map to a given center.
   */
  public void panTo(LatLng latlng, AbstractPanOptions optionsOptional) {
  }

  /**
   * Pans the map by a given number of pixels (animated).
   */
  public void panBy(LeafletPoint offset, AbstractPanOptions optionsOptional) {
  }

  /**
   * Sets the view of the map (geographical center and zoom) performing a smooth pan-zoom animation.
   */
  public void flyTo(LatLng latlng, Number zoomOptional, AbstractPanOptions optionsOptional) {
  }

  /**
   * Sets the view of the map with a smooth animation like flyTo, but takes a bounds parameter like fitBounds.
   */
  public void flyToBounds(LatLngBounds bounds, AbstractFitBoundsOptions optionsOptional) {
  }

  /**
   * Restricts the map view to the given bounds (see the maxBounds option).
   */
  public void setMaxBounds(Bounds bounds) {
    setProperty("bounds", bounds);
  }

  /**
   * Sets the lower limit for the available zoom levels (see the minZoom option).
   */
  public void setMinZoom(Number zoom) {
    setProperty("zoom", zoom);
  }

  /**
   * Sets the upper limit for the available zoom levels (see the maxZoom option).
   */
  public void setMaxZoom(Number zoom) {
    setProperty("zoom", zoom);
  }

  /**
   * Pans the map to the closest view that would lie inside the given bounds (if it's not already), controlling the animation using the options specific, if any.
   */
  public void panInsideBounds(LatLngBounds bounds, AbstractPanOptions optionsOptional) {
  }

  /**
   * Checks if the map container size changed and updates the map if so — call it after you've changed the map size dynamically, also animating pan by default. If options.pan is false, panning will not occur. If options.debounceMoveend is true, it will delay moveend event so that it doesn't happen often even if the method is called many times in a row.
   */
  public void invalidateSize(AbstractPanOptions options) {
  }

  /**
   * Checks if the map container size changed and updates the map if so — call it after you've changed the map size dynamically, also animating pan by default.
   */
  public void invalidateSize(Boolean animate) {
  }

  /**
   * Stops the currently running panTo or flyTo animation, if any.
   */
  public void stop() {
  }
}
