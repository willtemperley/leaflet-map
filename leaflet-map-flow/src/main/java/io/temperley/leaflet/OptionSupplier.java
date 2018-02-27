package io.temperley.leaflet;

import java.io.Serializable;
import java.util.function.Supplier;

public interface OptionSupplier<C extends OptionsBase>
        extends Supplier<C>, Serializable {

    /**
     * Gets this instance as a {@link OptionsBase}.
     *
     * @return this instance
     */
    @Override
    default C get() {
        return (C) this;
    }

}
