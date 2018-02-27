package io.temperley.leaflet;

import com.vaadin.flow.component.Component;

public class TakesServerOptions extends Component {

    public TakesServerOptions(OptionsBase options) {
        getElement().setProperty("opts", options.serialize());
    }
}
