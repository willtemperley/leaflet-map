package io.temperley.leaflet.layer;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("leaflet-tilelayer")
@HtmlImport("bower_components/leaflet-map/leaflet-layer.html")
public class LeafletTileLayer extends Component {

    public LeafletTileLayer url(String url) {
       getElement().setProperty("url", url);
       return this;
    }

    public LeafletTileLayer attribution(String url) {
        getElement().setProperty("attribution", url);
        return this;
    }


}
