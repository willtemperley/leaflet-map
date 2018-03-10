package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import io.temperley.leaflet.generated.AbstractFitBoundsOptions;
import io.temperley.leaflet.generated.AbstractPanOptions;
import io.temperley.leaflet.generated.AbstractZoomOptions;
import io.temperley.leaflet.basetypes.*;

public class CoerceTypes {

    /**
     * @param typeName a type string
     * @return the nearest class we can find for this JS type
     */

    public static ClassName classForJSType(String typeName) {

        typeName = getNormalisedTypeString(typeName);

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
            case "zoom/panoptions":
            case "panoptions":
                //Because zoom/pan and pan are so close just use one class
                return ClassName.get(AbstractPanOptions.class);
            case "zoomoptions":
                return ClassName.get(AbstractZoomOptions.class);
            case "crs":
                return ClassName.get(CRS.class);
            case "boolean|string":
                return ClassName.get(ZoomBehaviour.class);
            case "point":
                return ClassName.get(LeafletPoint.class);
            case "fitboundsoptions":
                return ClassName.get(AbstractFitBoundsOptions.class);
            case "renderer":
                return ClassName.get(Renderer.class);
            case "layer[]":
                return ClassName.get(LayerList.class);
            case "object":
            default:
                System.out.println("typeName = " + typeName);
                return ClassName.get(Object.class);
        }

    }

    /**
     * Just strip any characters that are sometimes there and sometimes not
     * @param typeName String type
     * @return a Java type
     */
    static String getNormalisedTypeString(String typeName) {
        typeName = typeName.toLowerCase().replaceAll(" ", "");
        typeName = typeName.replaceAll("<", "");
        typeName = typeName.replaceAll(">", "");
        return typeName;
    }
}
