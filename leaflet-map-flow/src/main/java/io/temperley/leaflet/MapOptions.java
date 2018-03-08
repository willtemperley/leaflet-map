package io.temperley.leaflet;

import java.lang.Boolean;
import java.lang.Number;
import java.lang.Object;

public class MapOptions extends OptionsBase<MapOptions> {
  /**
   * Whether Paths should be rendered on a Canvas renderer. By default, all Paths are rendered in a SVG renderer.
   * default: false
   */
  public MapOptions preferCanvas(Boolean preferCanvas) {
    addOption("preferCanvas", preferCanvas);
    return this;
  }

  /**
   * Whether a attribution control is added to the map by default.
   * default: true
   */
  public MapOptions attributionControl(Boolean attributionControl) {
    addOption("attributionControl", attributionControl);
    return this;
  }

  /**
   * Whether a zoom control is added to the map by default.
   * default: true
   */
  public MapOptions zoomControl(Boolean zoomControl) {
    addOption("zoomControl", zoomControl);
    return this;
  }

  /**
   * Set it to false if you don't want popups to close when user clicks the map.
   * default: true
   */
  public MapOptions closePopupOnClick(Boolean closePopupOnClick) {
    addOption("closePopupOnClick", closePopupOnClick);
    return this;
  }

  /**
   * Forces the map's zoom level to always be a multiple of this, particularly right after a fitBounds() or a pinch-zoom. By default, the zoom level snaps to the nearest integer; lower values (e.g. 0.5 or 0.1) allow for greater granularity. A value of 0 means the zoom level will not be snapped after fitBounds or a pinch-zoom.
   * default: 1
   */
  public MapOptions zoomSnap(Number zoomSnap) {
    addOption("zoomSnap", zoomSnap);
    return this;
  }

  /**
   * Controls how much the map's zoom level will change after a zoomIn(), zoomOut(), pressing + or - on the keyboard, or using the zoom controls. Values smaller than 1 (e.g. 0.5) allow for greater granularity.
   * default: 1
   */
  public MapOptions zoomDelta(Number zoomDelta) {
    addOption("zoomDelta", zoomDelta);
    return this;
  }

  /**
   * Whether the map automatically handles browser window resize to update itself.
   * default: true
   */
  public MapOptions trackResize(Boolean trackResize) {
    addOption("trackResize", trackResize);
    return this;
  }

  /**
   * Whether the map can be zoomed to a rectangular area specified by dragging the mouse while pressing the shift key.
   * default: true
   */
  public MapOptions boxZoom(Boolean boxZoom) {
    addOption("boxZoom", boxZoom);
    return this;
  }

  /**
   * Whether the map can be zoomed in by double clicking on it and zoomed out by double clicking while holding shift. If passed 'center', double-click zoom will zoom to the center of the view regardless of where the mouse was.
   * default: true
   */
  public MapOptions doubleClickZoom(Object doubleClickZoom) {
    addOption("doubleClickZoom", doubleClickZoom);
    return this;
  }

  /**
   * Whether the map be draggable with mouse/touch or not.
   * default: true
   */
  public MapOptions dragging(Boolean dragging) {
    addOption("dragging", dragging);
    return this;
  }

  /**
   * The Coordinate Reference System to use. Don't change this if you're not sure what it means.
   * default: L.CRS.EPSG3857
   */
  public MapOptions crs(Object crs) {
    addOption("crs", crs);
    return this;
  }

  /**
   * Initial geographic center of the map
   * default: undefined
   */
  public MapOptions center(Object center) {
    addOption("center", center);
    return this;
  }

  /**
   * Initial map zoom level
   * default: undefined
   */
  public MapOptions zoom(Number zoom) {
    addOption("zoom", zoom);
    return this;
  }

  /**
   * Minimum zoom level of the map. If not specified and at least one GridLayer or TileLayer is in the map, the lowest of their minZoom options will be used instead.
   * default: *
   */
  public MapOptions minZoom(Number minZoom) {
    addOption("minZoom", minZoom);
    return this;
  }

  /**
   * Maximum zoom level of the map. If not specified and at least one GridLayer or TileLayer is in the map, the highest of their maxZoom options will be used instead.
   * default: *
   */
  public MapOptions maxZoom(Number maxZoom) {
    addOption("maxZoom", maxZoom);
    return this;
  }

  /**
   * Array of layers that will be added to the map initially
   * default: []
   */
  public MapOptions layers(Object layers) {
    addOption("layers", layers);
    return this;
  }

  /**
   * When this option is set, the map restricts the view to the given geographical bounds, bouncing the user back if the user tries to pan outside the view. To set the restriction dynamically, use setMaxBounds method.
   * default: null
   */
  public MapOptions maxBounds(Object maxBounds) {
    addOption("maxBounds", maxBounds);
    return this;
  }

  /**
   * The default method for drawing vector layers on the map. L.SVG or L.Canvas by default depending on browser support.
   * default: *
   */
  public MapOptions renderer(Object renderer) {
    addOption("renderer", renderer);
    return this;
  }

  /**
   * Whether the map zoom animation is enabled. By default it's enabled in all browsers that support CSS3 Transitions except Android.
   * default: true
   */
  public MapOptions zoomAnimation(Boolean zoomAnimation) {
    addOption("zoomAnimation", zoomAnimation);
    return this;
  }

  /**
   * Won't animate zoom if the zoom difference exceeds this value.
   * default: 4
   */
  public MapOptions zoomAnimationThreshold(Number zoomAnimationThreshold) {
    addOption("zoomAnimationThreshold", zoomAnimationThreshold);
    return this;
  }

  /**
   * Whether the tile fade animation is enabled. By default it's enabled in all browsers that support CSS3 Transitions except Android.
   * default: true
   */
  public MapOptions fadeAnimation(Boolean fadeAnimation) {
    addOption("fadeAnimation", fadeAnimation);
    return this;
  }

  /**
   * Whether markers animate their zoom with the zoom animation, if disabled they will disappear for the length of the animation. By default it's enabled in all browsers that support CSS3 Transitions except Android.
   * default: true
   */
  public MapOptions markerZoomAnimation(Boolean markerZoomAnimation) {
    addOption("markerZoomAnimation", markerZoomAnimation);
    return this;
  }

  /**
   * Defines the maximum size of a CSS translation transform. The default value should not be changed unless a web browser positions layers in the wrong place after doing a large panBy.
   * default: 2^23
   */
  public MapOptions transform3DLimit(Number transform3DLimit) {
    addOption("transform3DLimit", transform3DLimit);
    return this;
  }

  /**
   * If enabled, panning of the map will have an inertia effect where the map builds momentum while dragging and continues moving in the same direction for some time. Feels especially nice on touch devices. Enabled by default unless running on old Android devices.
   * default: *
   */
  public MapOptions inertia(Boolean inertia) {
    addOption("inertia", inertia);
    return this;
  }

  /**
   * The rate with which the inertial movement slows down, in pixels/second².
   * default: 3000
   */
  public MapOptions inertiaDeceleration(Number inertiaDeceleration) {
    addOption("inertiaDeceleration", inertiaDeceleration);
    return this;
  }

  /**
   * Max speed of the inertial movement, in pixels/second.
   * default: Infinity
   */
  public MapOptions inertiaMaxSpeed(Number inertiaMaxSpeed) {
    addOption("inertiaMaxSpeed", inertiaMaxSpeed);
    return this;
  }

  /**
   * not defined
   * default: 0.2
   */
  public MapOptions easeLinearity(Number easeLinearity) {
    addOption("easeLinearity", easeLinearity);
    return this;
  }

  /**
   * With this option enabled, the map tracks when you pan to another "copy" of the world and seamlessly jumps to the original one so that all overlays like markers and vector layers are still visible.
   * default: false
   */
  public MapOptions worldCopyJump(Boolean worldCopyJump) {
    addOption("worldCopyJump", worldCopyJump);
    return this;
  }

  /**
   * If maxBounds is set, this option will control how solid the bounds are when dragging the map around. The default value of 0.0 allows the user to drag outside the bounds at normal speed, higher values will slow down map dragging outside bounds, and 1.0 makes the bounds fully solid, preventing the user from dragging outside the bounds.
   * default: 0.0
   */
  public MapOptions maxBoundsViscosity(Number maxBoundsViscosity) {
    addOption("maxBoundsViscosity", maxBoundsViscosity);
    return this;
  }

  /**
   * Makes the map focusable and allows users to navigate the map with keyboard arrows and +/- keys.
   * default: true
   */
  public MapOptions keyboard(Boolean keyboard) {
    addOption("keyboard", keyboard);
    return this;
  }

  /**
   * Amount of pixels to pan when pressing an arrow key.
   * default: 80
   */
  public MapOptions keyboardPanDelta(Number keyboardPanDelta) {
    addOption("keyboardPanDelta", keyboardPanDelta);
    return this;
  }

  /**
   * Whether the map can be zoomed by using the mouse wheel. If passed 'center', it will zoom to the center of the view regardless of where the mouse was.
   * default: true
   */
  public MapOptions scrollWheelZoom(Object scrollWheelZoom) {
    addOption("scrollWheelZoom", scrollWheelZoom);
    return this;
  }

  /**
   * Limits the rate at which a wheel can fire (in milliseconds). By default user can't zoom via wheel more often than once per 40 ms.
   * default: 40
   */
  public MapOptions wheelDebounceTime(Number wheelDebounceTime) {
    addOption("wheelDebounceTime", wheelDebounceTime);
    return this;
  }

  /**
   * How many scroll pixels (as reported by L.DomEvent.getWheelDelta) mean a change of one full zoom level. Smaller values will make wheel-zooming faster (and vice versa).
   * default: 60
   */
  public MapOptions wheelPxPerZoomLevel(Number wheelPxPerZoomLevel) {
    addOption("wheelPxPerZoomLevel", wheelPxPerZoomLevel);
    return this;
  }

  /**
   * Enables mobile hacks for supporting instant taps (fixing 200ms click delay on iOS/Android) and touch holds (fired as contextmenu events).
   * default: true
   */
  public MapOptions tap(Boolean tap) {
    addOption("tap", tap);
    return this;
  }

  /**
   * The max number of pixels a user can shift his finger during touch for it to be considered a valid tap.
   * default: 15
   */
  public MapOptions tapTolerance(Number tapTolerance) {
    addOption("tapTolerance", tapTolerance);
    return this;
  }

  /**
   * Whether the map can be zoomed by touch-dragging with two fingers. If passed 'center', it will zoom to the center of the view regardless of where the touch events (fingers) were. Enabled for touch-capable web browsers except for old Androids.
   * default: *
   */
  public MapOptions touchZoom(Object touchZoom) {
    addOption("touchZoom", touchZoom);
    return this;
  }

  /**
   * Set it to false if you don't want the map to zoom beyond min/max zoom and then bounce back when pinch-zooming.
   * default: true
   */
  public MapOptions bounceAtZoomLimits(Boolean bounceAtZoomLimits) {
    addOption("bounceAtZoomLimits", bounceAtZoomLimits);
    return this;
  }
}
