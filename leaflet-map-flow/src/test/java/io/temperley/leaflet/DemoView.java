package io.temperley.leaflet;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import io.temperley.leaflet.basetypes.LatLng;
import io.temperley.leaflet.basetypes.ZoomBehaviour;
import io.temperley.leaflet.control.LayersControl;
import io.temperley.leaflet.control.LayersControlOptions;
import io.temperley.leaflet.control.ScaleControl;
import io.temperley.leaflet.control.ScaleControlOptions;
import io.temperley.leaflet.generated.AbstractPanOptions;

@Route("")
@Theme(Lumo.class)
public class DemoView extends Div {

    public DemoView() {

        ScaleControlOptions scaleControlOptions = new ScaleControlOptions()
                .position("bottomright")
                .maxWidth(300)
                .metric(false);

        ScaleControl scaleControl = new ScaleControl(scaleControlOptions);

        MapOptions options = new MapOptions();
        options.zoom(9);
        options.center(new LatLng(41.9, 12.5));
        options.doubleClickZoom(ZoomBehaviour.Disabled);
        Map leafletMap = new Map(options);
//        leafletMap.setCentre(12.5, 41.9);
        leafletMap.getElement().getStyle().set("height", "400px");
        add(leafletMap);


        Button button = new Button("clickme");

        button.addClickListener(e -> {
            leafletMap.setView(new LatLng(42.9, 12.5), 7, new PanOptions().animate(true));
        });

        add(button);

//        String url = "https://stamen-tiles-{s}.a.ssl.fastly.net/toner/{z}/{x}/{y}.png";
//        TileLayerOptions options =
//                new TileLayerOptions(url)
//                .attribution("Map tiles by <a href=\"http://stamen.com\">Stamen Design</a>, <a href=\"http://creativecommons.org/licenses/by/3.0\">CC BY 3.0</a> &mdash; Map data &copy; <a href=\"http://www.openstreetmap.org/copyright\">OpenStreetMap</a>");
//
//        leafletMap.add( new TileLayer(options) );

//        leafletMap.add(scaleControl);
//        leafletMap.add(new LayersControl(new LayersControlOptions())); //todo add default ctor like this?
//
//        leafletMap.addValueChangeListener(event -> {
//
//            String mapState = leafletMap.getMapState();
//            System.out.println("mapState = " + mapState);
//
//        });



    }
}
