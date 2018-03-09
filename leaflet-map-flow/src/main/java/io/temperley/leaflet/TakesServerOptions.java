package io.temperley.leaflet;

import com.vaadin.flow.component.Component;

public class TakesServerOptions extends Component {

    public TakesServerOptions(OptionsBase options) {
        getElement().setProperty("opts", options.serialize());
    }

    public void setProperty(String propertyName, String property) {

    }

    public void setProperty(String propertyName, Boolean property) {

    }

    public void setProperty(String propertyName, LeafletSerializable leafletSerializable) {

    }

    protected void setProperty(String propertyName, Number number) {

    }
}
