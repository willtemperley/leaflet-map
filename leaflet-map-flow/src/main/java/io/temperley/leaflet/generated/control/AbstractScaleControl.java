package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-scale-control")
@HtmlImport("bower_components/leaflet-map/leaflet-scale-control.html")
public abstract class AbstractScaleControl extends AbstractControl {
    /**
     * Creates an scale control with the given options.
     */
    public AbstractScaleControl() {
        List<Object> objects = new ArrayList<>();
        setProperty("constructorargs", objects);
    }

    /**
     * Creates an scale control with the given options.
     */
    public AbstractScaleControl(LeafletSerializable options) {
        List<Object> objects = new ArrayList<>();
        objects.add(options.serializable());
        setProperty("constructorargs", objects);
    }
}
