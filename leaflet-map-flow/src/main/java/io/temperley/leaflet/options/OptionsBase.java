package io.temperley.leaflet.options;

import com.jsoniter.output.JsonStream;
import com.vaadin.flow.component.ComponentSupplier;
import io.temperley.leaflet.LeafletSerializable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OptionsBase<O> implements Supplier<O>, LeafletSerializable {
    private Map<String, Object> opts = new HashMap<>();

    public Object serializable() {
        return opts;
    }

    protected void addOption(String name, Object value) {
        opts.put(name, value);
    }

    protected void addOption(String name, LeafletSerializable value) {
        opts.put(name, value.serializable());
    }

    /**
     * Returns the correct subtype when building fluent APIs
     *
     * @return downcasts to return the subtype
     */
    public O get() {
        return (O) this;
    }
}
