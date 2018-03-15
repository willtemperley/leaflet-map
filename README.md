# leaflet-map

Polymer 2.0 webcomponent wrapper for LeafletJS;
Vaadin 10 server-side bindings

## Project structure
**./component** contains the Polymer2.0 web component

(This was inspired by
https://github.com/leaflet-extras/leaflet-map/
however the projects bear little resemblance to each other now).

**./leaflet-map-webjar** contains an empty maven project which serves simply to create a webjar. 

**./leaflet-map-flow** contains the server-side bindings for Vaadin 10 (Flow)

### Overall architecture
Every method name is mapped to a property on the component, including the constructor.
All information required to perform a method invocation is sent in a JSON object, e.g.:
```json

{
    "methodName": "setView",
    "params": [
      [1,2], 7
    ],
    "nonce": 1345899798
}
```

The nonce isn't checked, it's just sent to ensure the property observer is always triggered.
All JS classes inherit from LeafletCore which will invoke the required method on "obj", 
the actual leaflet object defined by subclasses.

### Algorithmic generation of bindings

Much of the code is boilerplate; the real heavy lifting is done by LeafletJS iteslf. 
The LeafletJS documentation is thorough, so the method signatures were copied into e.g.: 

[Map Methods](leaflet-map-flow/src/test/resources/leaflet-api/map-methods.tsv)

[Map Options](leaflet-map-flow/src/test/resources/leaflet-api/map-options.tsv)

Tags and their mappings to class names are defined [here](leaflet-map-flow/src/test/resources/tags.tsv).

The method and option definitions are used to generate the vast majority of the code,
with the exception of core JavaScript and top-level Java classes.
The latter are generally very simple, acting as entry points, 
often just passing themselves as a type parameter to inform the fluent api.
They also serve as extension points or places to sugar the api.
Java files are generated using the excellent JavaPoet library. 

Algorithmic code generation gives a number of advantages:
1. The api should be familiar to anyone who's used LeafletJS as it's exactly reflected in Java.
2. Fewer bugs caused by typos or copy/paste snafu
3. Code documentation can also be generated
4. API updates should just mean minor edits to method/option definitions.


### Options
Options are built with a fluent API. For each automatically generated abstract options class there is a manually 
created concrete type. This simply passes itself as a type parameter, which is recursively applied to superclasses.
This provides an entry point at each level in the hierarchy. 

### Methods
TODO: Return this, need fluent API as in options

## Running the Vaadin bindings
cd to ./leaflet-map-flow and run `mvn jetty:run`

## Running the webcomponent
Make sure you have the [Polymer CLI](https://www.npmjs.com/package/polymer-cli) installed.
cd to ./component and run `polymer serve --open`

### Leaflet extras demo:
http://leaflet-extras.github.io/leaflet-providers/preview/
