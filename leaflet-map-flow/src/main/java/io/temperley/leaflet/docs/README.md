### Codegen

The aim is to reflect as exactly as possible the leaflet api. This means:
1. The api should be familiar to anyone
2. ode documentation can also be generated
3. Fewer bugs caused by typos or copy/paste snafu

### Java
Java files are generated using JavaPoet. 
All generated files are declared abstract, 
then a concrete type is created at whichever level required.
Any sugar on the leaflet API can be added manually on these classes.

### Options
Options are built with a fluent API. For each automatically generated abstract options class there is a manually 
created concrete type. This simply passes itself as a type parameter, which is recursively applied to superclasses.
This provides an entry point at each level in the hierarchy. 

### Methods
TODO: Return this, need fluent API as in options

### JS
Every method name is mapped to a property on the component.
All information required to perform a method invocation is sent in a JSON object, e.g.:

```json

{
    "methodName": "setView",
    "params": [
      [1,2], 7
    ],
    "nonce": 1345899798  //this isn't checked, it's just sent to ensure the property observer is always triggered
}
```

all classes inherit from LeafletCore which will invoke the required method on "obj", 
the actual leaflet object defined by subclasses.

