### Codegen

The aim is to reflect as exactly as possible the leaflet api:
1. This means code documentation can also be generated
2. The api should be familiar to anyone
3. Fewer special cases in JavaScript means writing less JavaScript
4. Fewer bugs caused by typos or copy/paste snafu


### Options
Options are built with a fluent API. For each automatically generated abstract options class there is a manually 
created concrete type. This simply passes itself as a type parameter, which is recursively applied to superclasses.
This provides an entry point at each level in the hierarchy. 

### Methods

TODO: concrete types in GenMethods 

### JS

Every method is called using a JSON invocation

```json

{
    "methodString": "setView",
    "params": [
      [1,2], 7
    ]
}
```


