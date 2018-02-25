package io.temperley.leaflet;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import io.temperley.leaflet.layer.LeafletTileLayer;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        LeafletScaleControl scaleControl = new LeafletScaleControl()
                        .position("bottomright")
                        .maxWidthPx(300)
                        .metric(false)
                ;

        LeafletMap leafletMap = new LeafletMap(10);
        leafletMap.setCentre(12.5, 41.9);
        leafletMap.getElement().getStyle().set("height", "400px");
        add(leafletMap);

        leafletMap.add(
                new LeafletTileLayer()
                .url("https://stamen-tiles-{s}.a.ssl.fastly.net/toner/{z}/{x}/{y}.png")
        );

        leafletMap.add(scaleControl);

        leafletMap.addValueChangeListener(event -> {

            String mapState = leafletMap.getMapState();
            System.out.println("mapState = " + mapState);

        });

    }
}
