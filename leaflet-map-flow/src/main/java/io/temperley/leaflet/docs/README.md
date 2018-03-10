### Codegen

The aim is to reflect as exactly as possible the leaflet api:
1. This means code documentation can also be generated
2. The api should be familiar to anyone
3. Fewer special cases in JavaScript means writing less JavaScript
4. Fewer bugs caused by typos or copy/paste snafu


### Options
Options are built with a fluent API. Abstract classes are generated with the methods and a concrete type 
manually created simply to pass itself as a type parameter, which is recursively applied to superclasses.

TODO: concrete types in GenMethods 

### JS

For every method, the idea is to have a param list something like this:

```json

{
    "method": "fitToBounds",
    "params": [
        {
         "type": "L.LatLng",
         "params": ""
        }
    ]
}
```


