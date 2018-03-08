package io.temperley.leaflet;

import com.jsoniter.output.JsonStream;
import com.vaadin.flow.component.ComponentSupplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OptionsBase<O> implements Supplier<O> {
    private Map<String, Object> opts = new HashMap<>();

    public String serialize() {
        return JsonStream.serialize(opts);
    }

    protected void addOption(String name, Object value) {
        opts.put(name, value);
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
