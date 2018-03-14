package io.temperley.leaflet.generated;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.FitBoundsOptions;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.PanOptions;
import io.temperley.leaflet.ZoomOptions;
import io.temperley.leaflet.basetypes.Bounds;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.basetypes.LatLngBounds;
import io.temperley.leaflet.basetypes.LeafletPoint;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.Boolean;
import java.lang.Number;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-map")
@HtmlImport("bower_components/leaflet-map/leaflet-map.html")
public abstract class AbstractMap extends TakesServerOptions {
  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public AbstractMap() {
    List<Object> objects = new ArrayList<>();
    setProperty("constructorargs", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public AbstractMap(LeafletSerializable options) {
    List<Object> objects = new ArrayList<>();
    objects.add(options.serializable());
    setProperty("constructorargs", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public void setView(LatLng center, Number zoom) {
    List<Object> objects = new ArrayList<>();
    objects.add(center.serializable());
    objects.add(zoom);
    setProperty("setView", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) with the given animation options.
   */
  public void setView(LatLng center, Number zoom, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(center.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setView", objects);
  }

  /**
   * Sets the zoom of the map.
   */
  public void setZoom(Number zoom) {
    List<Object> objects = new ArrayList<>();
    objects.add(zoom);
    setProperty("setZoom", objects);
  }

  /**
   * Sets the zoom of the map.
   */
  public void setZoom(Number zoom, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setZoom", objects);
  }

  /**
   * Increases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomIn() {
    List<Object> objects = new ArrayList<>();
    setProperty("zoomIn", objects);
  }

  /**
   * Increases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomIn(Number delta) {
    List<Object> objects = new ArrayList<>();
    objects.add(delta);
    setProperty("zoomIn", objects);
  }

  /**
   * Increases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomIn(Number delta, ZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(delta);
    objects.add(options.serializable());
    setProperty("zoomIn", objects);
  }

  /**
   * Decreases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomOut() {
    List<Object> objects = new ArrayList<>();
    setProperty("zoomOut", objects);
  }

  /**
   * Decreases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomOut(Number delta) {
    List<Object> objects = new ArrayList<>();
    objects.add(delta);
    setProperty("zoomOut", objects);
  }

  /**
   * Decreases the zoom of the map by delta (zoomDelta by default).
   */
  public void zoomOut(Number delta, ZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(delta);
    objects.add(options.serializable());
    setProperty("zoomOut", objects);
  }

  /**
   * Zooms the map while keeping a specified geographical point on the map stationary (e.g. used internally for scroll zoom and double-click zoom).
   */
  public void setZoomAround(LatLng latlng, Number zoom, ZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setZoomAround", objects);
  }

  /**
   * Zooms the map while keeping a specified pixel on the map (relative to the top-left corner) stationary.
   */
  public void setZoomAround(LeafletPoint offset, Number zoom, ZoomOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(offset.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("setZoomAround", objects);
  }

  /**
   * Sets a map view that contains the given geographical bounds with the maximum zoom level possible.
   */
  public void fitBounds(LatLngBounds bounds) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    setProperty("fitBounds", objects);
  }

  /**
   * Sets a map view that contains the given geographical bounds with the maximum zoom level possible.
   */
  public void fitBounds(LatLngBounds bounds, FitBoundsOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(options.serializable());
    setProperty("fitBounds", objects);
  }

  /**
   * Sets a map view that mostly contains the whole world with the maximum zoom level possible.
   */
  public void fitWorld() {
    List<Object> objects = new ArrayList<>();
    setProperty("fitWorld", objects);
  }

  /**
   * Sets a map view that mostly contains the whole world with the maximum zoom level possible.
   */
  public void fitWorld(FitBoundsOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(options.serializable());
    setProperty("fitWorld", objects);
  }

  /**
   * Pans the map to a given center.
   */
  public void panTo(LatLng latlng) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    setProperty("panTo", objects);
  }

  /**
   * Pans the map to a given center.
   */
  public void panTo(LatLng latlng, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(options.serializable());
    setProperty("panTo", objects);
  }

  /**
   * Pans the map by a given number of pixels (animated).
   */
  public void panBy(LeafletPoint offset) {
    List<Object> objects = new ArrayList<>();
    objects.add(offset.serializable());
    setProperty("panBy", objects);
  }

  /**
   * Pans the map by a given number of pixels (animated).
   */
  public void panBy(LeafletPoint offset, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(offset.serializable());
    objects.add(options.serializable());
    setProperty("panBy", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) performing a smooth pan-zoom animation.
   */
  public void flyTo(LatLng latlng) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    setProperty("flyTo", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) performing a smooth pan-zoom animation.
   */
  public void flyTo(LatLng latlng, Number zoom) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(zoom);
    setProperty("flyTo", objects);
  }

  /**
   * Sets the view of the map (geographical center and zoom) performing a smooth pan-zoom animation.
   */
  public void flyTo(LatLng latlng, Number zoom, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(latlng.serializable());
    objects.add(zoom);
    objects.add(options.serializable());
    setProperty("flyTo", objects);
  }

  /**
   * Sets the view of the map with a smooth animation like flyTo, but takes a bounds parameter like fitBounds.
   */
  public void flyToBounds(LatLngBounds bounds) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    setProperty("flyToBounds", objects);
  }

  /**
   * Sets the view of the map with a smooth animation like flyTo, but takes a bounds parameter like fitBounds.
   */
  public void flyToBounds(LatLngBounds bounds, FitBoundsOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(options.serializable());
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
  public void panInsideBounds(LatLngBounds bounds) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    setProperty("panInsideBounds", objects);
  }

  /**
   * Pans the map to the closest view that would lie inside the given bounds (if it's not already), controlling the animation using the options specific, if any.
   */
  public void panInsideBounds(LatLngBounds bounds, PanOptions options) {
    List<Object> objects = new ArrayList<>();
    objects.add(bounds.serializable());
    objects.add(options.serializable());
    setProperty("panInsideBounds", objects);
  }

  /**
   * Checks if the map container size changed and updates the map if so — call it after you've changed the map size dynamically, also animating pan by default. If options.pan is false, panning will not occur. If options.debounceMoveend is true, it will delay moveend event so that it doesn't happen often even if the method is called many times in a row.
   */
  public void invalidateSize(PanOptions options) {
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
