#leaflet-map

Polymer 2.0 wrapper for LeafletJS and webjar

## Project structure
./component contains the Polymer2.0 web component

./leaflet-map contains an empty maven project which serves simply to create a webjar. 
This is most likely to be useful if you're developing a Vaadin 10 (Flow) application.

### Importing into Intellij
Tip: if you're having issues getting both root folders to show up, try this:
Go to:
File->Project Structure->Modules.
Instead of adding module, simply click the third option (copy). Browse your local directory and select the project you would like to add. Module name will resolve automatically. That's it.

## Install the Polymer-CLI

First, make sure you have the [Polymer CLI](https://www.npmjs.com/package/polymer-cli) installed. Then run `polymer serve` to serve your element locally.

## Viewing Your Element

```
$ polymer serve
```

## Running Tests

```
$ polymer test
```

Your application is already set up to be tested via [web-component-tester](https://github.com/Polymer/web-component-tester). Run `polymer test` to run your application's test suite locally.
