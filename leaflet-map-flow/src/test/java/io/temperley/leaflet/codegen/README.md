### Codegen

The aim is to reflect as exactly as possible the leaflet api:
1. This means code documentation can also be generated
2. The api should be familiar to anyone
3. Fewer special cases in JavaScript means writing less JavaScript


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


