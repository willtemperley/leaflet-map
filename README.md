# leaflet-map

Polymer 2.0 webcomponent wrapper for LeafletJS;
Vaadin 10 server-side bindings

## Project structure
**./component** contains the Polymer2.0 web component

This has mostly been ported from the Polymer 1.0 component:
https://github.com/leaflet-extras/leaflet-map/

Still need to go through the un-merged pull requests:
https://github.com/leaflet-extras/leaflet-map/pulls

**./leaflet-map-webjar** contains an empty maven project which serves simply to create a webjar. 

**./leaflet-map-flow** contains the server-side bindings for Vaadin 10 (Flow)

## Client-server communication

Currently the idea is to have client-side properties that are specifically to be read and set by the server.
e.g. mapState which can be used to retrieve the basic state of the map.

The process for communicating properties is somewhat unclear:
"There are many cases where you can use either an attribute or a property with the same 
name for the same effect. In some cases only one of them works, in other cases the attribute is considered
when the element is initialized, but after initialization only the property is effective. 
Please check documentation specific to the element you’re using to find out whether a feature 
should be configured using a property or an attribute."

Instead of worrying about this stuff, the idea is to simply provide a single configuration variable (opts) 
for all components. This makes life much simpler as it is difficult to get all the webcomponent properties 
and attributes together at construction time.  
Attempting to use component properties entirely was attempted with the scalecontrol, but doing so required
removal and reconstruction as many times as there are properties, as mutators are not available for some options.

This approach means the options can be built as a map server-side, then serialized to JSON.
This can be directly used to feed options parameters on the client. 

It may be preferable to simplify the API and keep as close as possible to the leaflet API.
This might mean we can just generate the entire API.

Todo: Generate methods


### Importing into Intellij
Tip: if you're having issues getting all root folders to show up, try this:
Go to: File->Project Structure->Modules.
To add a the module, click the third option (copy). Browse your local directory and select the folder you would like to add.

## Running the Vaadin bindings
cd to ./leaflet-map-flow and run `mvn jetty:run`

## Running the webcomponent
Make sure you have the [Polymer CLI](https://www.npmjs.com/package/polymer-cli) installed.
cd to ./component and run `polymer serve --open`

## Notes on Polymer 1 to 2 migration
Don't forget to register your component!
```$xslt
  window.customElements.define(LeafletTileLayerWMS.is, LeafletTileLayerWMS);
```

Replace:
```$js
	is: 'leaflet-geojson',

	properties: {
	    ...
	}

```

With:
```$js

  static get is() {
	   return 'leaflet-geojson';
  }
  
  static get properties() {
  
  }
```

Replace:
```$js
fire(e.type, e) with:
```
With:
          
```
  this.dispatchEvent(new CustomEvent(e.type, e));
```

Use `this.shadowRoot` in place of `Polymer.dom(this.root)`

https://www.polymer-project.org/2.0/docs/upgrade#polymer-dom-apis

### Leaflet extras demo:
http://leaflet-extras.github.io/leaflet-providers/preview/
