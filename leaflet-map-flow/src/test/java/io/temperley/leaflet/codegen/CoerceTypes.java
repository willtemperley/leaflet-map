package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import com.vaadin.flow.dom.Element;
import io.temperley.leaflet.FitBoundsOptions;
import io.temperley.leaflet.LeafletSerializable;
import io.temperley.leaflet.PanOptions;
import io.temperley.leaflet.ZoomOptions;
import io.temperley.leaflet.basetypes.*;
import io.temperley.leaflet.codegen.markers.ConstructorMarker;
import io.temperley.leaflet.codegen.markers.ThisMarker;
import io.temperley.leaflet.layers.Layer;
import io.temperley.leaflet.layers.MarkerOptions;
import io.temperley.leaflet.ui.Popup;
import io.temperley.leaflet.ui.PopupOptions;

public class CoerceTypes {

    /**
     * @param typeName a type string
     * @return the nearest class we can find for this JS type
     */

    public static ClassName classForJSType(String typeName) {

        typeName = normalizeTypeString(typeName);

        switch (typeName) {
            case "string":
                return ClassName.get(String.class);
            case "boolean":
                return ClassName.get(Boolean.class);
            case "number":
                return ClassName.get(Number.class);
            case "latlng":
                return ClassName.get(LatLng.class);
            case "bounds":
                return ClassName.get(Bounds.class);
            case "latlngbounds":
                return ClassName.get(LatLngBounds.class);
            //Because zoom/pan and pan are so close just use one class
            case "zoom/panoptions":
            case "panoptions":
                return ClassName.get(PanOptions.class);
            case "zoomoptions":
                return ClassName.get(ZoomOptions.class);
            case "crs":
                return ClassName.get(CRS.class);
            case "boolean|string":
                return ClassName.get(ZoomBehaviour.class);
            case "point":
                return ClassName.get(LeafletPoint.class);
            case "fitboundsoptions":
                return ClassName.get(FitBoundsOptions.class);
            case "renderer":
                return ClassName.get(Renderer.class);
            case "layer[]":
                return ClassName.get(LayerList.class);
            case "layer":
                return ClassName.get(Layer.class);
            case "this":
                return ClassName.get(ThisMarker.class);
            case "ctor":
                return ClassName.get(ConstructorMarker.class);
            case "htmlelement":
                return ClassName.get(Element.class);
            case "icon":
                return ClassName.get(Icon.class);
            case "markeroptions":
                return ClassName.get(MarkerOptions.class);
            case "iconoptions":
                return ClassName.get(Icon.class);
            case "popupoptions":
                return ClassName.get(PopupOptions.class);
            case "string|htmlelement":
            case "string|htmlelement|popup":
            case "string|htmlelement|function":
            case "string|htmlelement|function|popup":
                //todo element is possible
                return ClassName.get(String.class);
            case "popup":
                return ClassName.get(Popup.class);
            case "object":
            default:
                return ClassName.get(LeafletSerializable.class);
        }

    }

    /**
     * Just strip any characters that are sometimes there and sometimes not
     * @param typeName String type
     * @return a Java type
     */
    static String normalizeTypeString(String typeName) {
        typeName = typeName.toLowerCase().replaceAll(" ", "");
        typeName = typeName.replaceAll("<", "");
        typeName = typeName.replaceAll(">", "");
        return typeName;
    }
}
