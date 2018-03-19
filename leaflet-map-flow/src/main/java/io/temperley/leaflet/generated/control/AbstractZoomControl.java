package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-zoom-control")
@HtmlImport("bower_components/leaflet-map/leaflet-zoom-control.html")
public abstract class AbstractZoomControl extends AbstractControl {
    /**
     * Creates a zoom control
     */
    public AbstractZoomControl(LeafletSerializable options) {
        List<Object> objects = new ArrayList<>();
        objects.add(options.serializable());
        setProperty("constructorargs", objects);
    }
}
