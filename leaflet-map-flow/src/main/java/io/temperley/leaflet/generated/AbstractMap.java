package io.temperley.leaflet.generated;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.basetypes.Bounds;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.basetypes.LatLngBounds;
import io.temperley.leaflet.basetypes.LeafletPoint;
import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.Boolean;
import java.lang.Number;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-map")
@HtmlImport("bower_components/leaflet-map/leaflet-map.html")
public class AbstractMap extends TakesServerOptions {
  public AbstractMap(OptionsBase options) {
    super(options);
  }

  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public void setView(LatLng center, Number zoom, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(center.serializable());
    objects.add(zoom);
    objects.add(optionsOptional.serializable());
    setProperty("setView", objects);
  }

  /**
   * Sets the zoom of the map.
   */
  public void setZoom(Number zoom, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(zoom);
    objects.add(optionsOptional.serializable());
    setProperty("setZoom", objects);
  }

  /**
   * Increases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomIn(Number deltaOptional, AbstractZoomOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(deltaOptional);
    objects.add(optionsOptional.serializable());
    setProperty("zoomIn", objects);
  }

  /**
   * Decreases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomOut(Number deltaOptional, AbstractZoomOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(deltaOptional);
    objects.add(optionsOptional.serializable());
    setProperty("zoomOut", objects);
  }

  /**
   * Zooms the map while keeping a specified geographical point on the map stationary (e.g. used internally for scroll zoom and double-click zoom).
   */
  public void setZoomAround(LatLng latlng, Number zoom, AbstractZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setZoomAround", objects);
  }

  /**
   * Zooms the map while keeping a specified pixel on the map (relative to the top-left corner) stationary.
   */
  public void setZoomAround(LeafletPoint offset, Number zoom, AbstractZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(offset.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setZoomAround", objects);
  }

  /**
   * Sets a map view that contains the given geographical bounds with the maximum zoom level possible.
   */
  public void fitBounds(LatLngBounds bounds, AbstractFitBoundsOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(optionsOptional.serializable());
    setProperty("fitBounds", objects);
  }

  /**
   * Sets a map view that mostly contains the whole world with the maximum zoom level possible.
   */
  public void fitWorld(AbstractFitBoundsOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(optionsOptional.serializable());
    setProperty("fitWorld", objects);
  }

  /**
   * Pans the map to a given center.
   */
  public void panTo(LatLng latlng, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(optionsOptional.serializable());
    setProperty("panTo", objects);
  }

  /**
   * Pans the map by a given number of pixels (animated).
   */
  public void panBy(LeafletPoint offset, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(offset.serializable());
    objects.add(optionsOptional.serializable());
    setProperty("panBy", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) performing a smooth pan-zoom animation.
   */
  public void flyTo(LatLng latlng, Number zoomOptional, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(zoomOptional);
    objects.add(optionsOptional.serializable());
    setProperty("flyTo", objects);
  }

  /**
   * Sets the view of the map with a smooth animation like flyTo, but takes a bounds parameter like fitBounds.
   */
  public void flyToBounds(LatLngBounds bounds, AbstractFitBoundsOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(optionsOptional.serializable());
    setProperty("flyToBounds", objects);
  }

  /**
   * Restricts the map view to the given bounds (see the maxBounds option).
   */
  public void setMaxBounds(Bounds bounds) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    setProperty("setMaxBounds", objects);
  }

  /**
   * Sets the lower limit for the available zoom levels (see the minZoom option).
   */
  public void setMinZoom(Number zoom) {
    List<Object> objects = new ArrayList<>();
    objects.add(zoom);
    setProperty("setMinZoom", objects);
  }

  /**
   * Sets the upper limit for the available zoom levels (see the maxZoom option).
   */
  public void setMaxZoom(Number zoom) {
    List<Object> objects = new ArrayList<>();
    objects.add(zoom);
    setProperty("setMaxZoom", objects);
  }

  /**
   * Pans the map to the closest view that would lie inside the given bounds (if it's not already), controlling the animation using the options specific, if any.
   */
  public void panInsideBounds(LatLngBounds bounds, AbstractPanOptions optionsOptional) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(optionsOptional.serializable());
    setProperty("panInsideBounds", objects);
  }

  /**
   * Checks if the map container size changed and updates the map if so — call it after you've changed the map size dynamically, also animating pan by default. If options.pan is false, panning will not occur. If options.debounceMoveend is true, it will delay moveend event so that it doesn't happen often even if the method is called many times in a row.
   */
  public void invalidateSize(AbstractPanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(options.serializable());
    setProperty("invalidateSize", objects);
  }

  /**
   * Checks if the map container size changed and updates the map if so — call it after you've changed the map size dynamically, also animating pan by default.
   */
  public void invalidateSize(Boolean animate) {
    List<Object> objects = new ArrayList<>();
    objects.add(animate);
    setProperty("invalidateSize", objects);
  }

  /**
   * Stops the currently running panTo or flyTo animation, if any.
   */
  public void stop() {
    List<Object> objects = new ArrayList<>();
    setProperty("stop", objects);
  }
}
