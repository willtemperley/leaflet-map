# leaflet-map

Polymer 2.0 webcomponent wrapper for LeafletJS and Vaadin 10 server-side bindings

## Project structure
**./component** contains the Polymer2.0 web component

**./leaflet-map-webjar** contains an empty maven project which serves simply to create a webjar. 

**./leaflet-map-flow** contains the server-side bindings for Vaadin 10 (Flow)

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
