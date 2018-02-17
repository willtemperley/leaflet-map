package io.temperley;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        LeafletMap leafletMap = new LeafletMap(10);
        leafletMap.setCentre(12, 41.9);
        leafletMap.getElement().getStyle().set("height", "400px");
        add(leafletMap);
    }
}
