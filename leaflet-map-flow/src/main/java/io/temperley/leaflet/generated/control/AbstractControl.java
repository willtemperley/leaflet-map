package io.temperley.leaflet.generated.control;

import com.vaadin.flow.dom.Element;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.options.TakesServerOptions;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractControl extends TakesServerOptions {
    /**
     * Returns the position of the control.
     */
    public String getPosition() {
        return getElement().getProperty("position");
    }

    /**
     * Sets the position of the control.
     */
    public void setPosition(String position) {
        List<Object> objects = new ArrayList<>();
        objects.add(position);
        setProperty("setPosition", objects);
    }

    /**
     * Returns the HTMLElement that contains the control.
     */
    public Element getContainer() {
        return getElement().getParent();
    }

    /**
     * Adds the control to the given map.
     */
    public void addTo(LeafletSerializable map) {
        throw new RuntimeException("Not implemented. Use add() method on element.");
    }

    /**
     * Removes the control from the map it is currently active on.
     */
    public void remove() {
        getElement().removeFromParent();
    }
}
