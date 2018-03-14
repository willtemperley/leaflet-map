package io.temperley.leaflet;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.shared.Registration;
import io.temperley.leaflet.events.MapViewChangeEvent;
import io.temperley.leaflet.generated.AbstractMap;
import io.temperley.leaflet.options.OptionsBase;

public class Map extends AbstractMap {

  public Map() {
    super();
  }

  public Map(int height, OptionsBase options) {

    //fixme no need
    super(options);
    getElement().getStyle().set("height", height + "px");
  }

  @Synchronize({"moveend", "zoomend", "dragend"})
  public String getMapState() {
    return getElement().getProperty("mapState", "");
  }

  public Registration addValueChangeListener(
          ComponentEventListener<MapViewChangeEvent> valueChangeListener) {
    return super.addListener(MapViewChangeEvent.class, valueChangeListener);
  }
}
