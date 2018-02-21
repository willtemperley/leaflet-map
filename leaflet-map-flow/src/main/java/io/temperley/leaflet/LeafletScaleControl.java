package io.temperley.leaflet;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("leaflet-scale-control")
@HtmlImport("bower_components/leaflet-map/leaflet-scale-control.html")
public class LeafletScaleControl extends Component {

    public LeafletScaleControl imperial(boolean imperial) {
        getElement().setProperty("imperial", imperial);
        return this;
    }

    public LeafletScaleControl metric(boolean metric) {
        getElement().setProperty("metric", metric);
        return this;
    }

    public LeafletScaleControl maxWidthPx(int maxWidth) {
        getElement().setProperty("maxwidth", Integer.toString(maxWidth));
        return this;
    }

    public LeafletScaleControl position(String position) {
        getElement().setProperty("position", position);
        return this;
    }

    public LeafletScaleControl updateWhileIdle(boolean updateWhileIdle) {
        getElement().setProperty("updatewhileidle", updateWhileIdle);
        return this;
    }
}
