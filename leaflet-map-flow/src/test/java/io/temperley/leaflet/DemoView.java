package io.temperley.leaflet;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import io.temperley.leaflet.control.ScaleControl;
import io.temperley.leaflet.control.ScaleControlOptions;
import io.temperley.leaflet.layer.LeafletTileLayer;
import io.temperley.leaflet.layer.TileLayerOptions;

@Route("")
public class DemoView extends Div {

    public DemoView() {

        ScaleControlOptions scaleControlOptions = new ScaleControlOptions()
                .position("bottomright")
                .maxWidth(300)
                .metric(false);

        ScaleControl scaleControl = new ScaleControl(scaleControlOptions);

        LeafletMap leafletMap = new LeafletMap().zoom(9);
        leafletMap.setCentre(12.5, 41.9);
        leafletMap.getElement().getStyle().set("height", "400px");
        add(leafletMap);

//        String url = "https://stamen-tiles-{s}.a.ssl.fastly.net/toner/{z}/{x}/{y}.png";
//        TileLayerOptions options =
//                new TileLayerOptions(url)
//                .attribution("Map tiles by <a href=\"http://stamen.com\">Stamen Design</a>, <a href=\"http://creativecommons.org/licenses/by/3.0\">CC BY 3.0</a> &mdash; Map data &copy; <a href=\"http://www.openstreetmap.org/copyright\">OpenStreetMap</a>");
//
//        leafletMap.add( new LeafletTileLayer(options) );

        leafletMap.add(scaleControl);

        leafletMap.addValueChangeListener(event -> {

            String mapState = leafletMap.getMapState();
            System.out.println("mapState = " + mapState);

        });

    }
}
