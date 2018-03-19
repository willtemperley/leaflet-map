package io.temperley.leaflet.generated.control;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.layers.Layer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Tag("leaflet-layers-control")
@HtmlImport("bower_components/leaflet-map/leaflet-layers-control.html")
public abstract class AbstractLayersControl extends AbstractControl {
    /**
     * Creates an attribution control with the given layers. Base layers will be switched with radio buttons, while overlays will be switched with checkboxes. Note that all base layers should be passed in the base layers object, but only one should be added to the map during map instantiation.
     */
    public AbstractLayersControl() {
        List<Object> objects = new ArrayList<>();
        setProperty("constructorargs", objects);
    }

    /**
     * Creates an attribution control with the given layers. Base layers will be switched with radio buttons, while overlays will be switched with checkboxes. Note that all base layers should be passed in the base layers object, but only one should be added to the map during map instantiation.
     */
    public AbstractLayersControl(LeafletSerializable baselayers) {
        List<Object> objects = new ArrayList<>();
        objects.add(baselayers.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Creates an attribution control with the given layers. Base layers will be switched with radio buttons, while overlays will be switched with checkboxes. Note that all base layers should be passed in the base layers object, but only one should be added to the map during map instantiation.
     */
    public AbstractLayersControl(LeafletSerializable baselayers, LeafletSerializable overlays) {
        List<Object> objects = new ArrayList<>();
        objects.add(baselayers.serializable());
        objects.add(overlays.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Creates an attribution control with the given layers. Base layers will be switched with radio buttons, while overlays will be switched with checkboxes. Note that all base layers should be passed in the base layers object, but only one should be added to the map during map instantiation.
     */
    public AbstractLayersControl(LeafletSerializable baselayers, LeafletSerializable overlays,
            LeafletSerializable options) {
        List<Object> objects = new ArrayList<>();
        objects.add(baselayers.serializable());
        objects.add(overlays.serializable());
        objects.add(options.serializable());
        setProperty("constructorargs", objects);
    }

    /**
     * Adds a base layer (radio button entry) with the given name to the control.
     */
    public void addBaseLayer(Layer layer, String name) {
        List<Object> objects = new ArrayList<>();
        objects.add(layer.serializable());
        objects.add(name);
        setProperty("addBaseLayer", objects);
    }

    /**
     * Adds an overlay (checkbox entry) with the given name to the control.
     */
    public void addOverlay(Layer layer, String name) {
        List<Object> objects = new ArrayList<>();
        objects.add(layer.serializable());
        objects.add(name);
        setProperty("addOverlay", objects);
    }

    /**
     * Remove the given layer from the control.
     */
    public void removeLayer(Layer layer) {
        List<Object> objects = new ArrayList<>();
        objects.add(layer.serializable());
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
