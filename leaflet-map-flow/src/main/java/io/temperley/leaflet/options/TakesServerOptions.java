package io.temperley.leaflet.options;

import com.jsoniter.output.JsonStream;
import com.vaadin.flow.component.Component;
import io.temperley.leaflet.LeafletSerializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TakesServerOptions extends Component {

//    public TakesServerOptions(OptionsBase options) {
//        String serialized = JsonStream.serialize(options.serializable());
//        getElement().setProperty("opts", serialized);
//    }

    protected void setProperty(String propertyName, List<Object> args) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("args", args);
        objectMap.put("nonce", System.currentTimeMillis());//Hack to make observers fire on web component
        objectMap.put("methodName", propertyName);
        String serialized = JsonStream.serialize(objectMap);
        getElement().setProperty(propertyName, serialized);
    }

}
