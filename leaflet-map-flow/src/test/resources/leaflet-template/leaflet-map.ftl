<!--<link rel="import" href="../polymer/polymer-element.html">-->
<link rel="import" href="leaflet-core.html">
<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js"
        integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw=="
        crossorigin=""></script>

<link rel="import" href="leaflet-marker.html">
<link rel="import" href="leaflet-layer.html">
<link rel="import" href="leaflet-layer-group.html">
<link rel="import" href="leaflet-scale-control.html">
<link rel="import" href="leaflet-geojson.html">

<dom-module id="leaflet-map">
  <template>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css"
          integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ=="
          crossorigin=""/>
    <style>
      :host {
        display: block;
      }

      :host #map {
        height: 100%;
        width: 100%
      }

    </style>
    <div id="map">

    </div>
    <slot></slot>
  </template>

  <script>
    /**
     * `leaflet-map`
     * lmap
     *
     * @customElement
     * @polymer
     * @demo demo/index.html
     */
    class ${className} extends LeafletCore {
      static get is() {
        return '${tagName}';
      }

      static get properties() {
        return {

          mapState: {
            type: String,
          },

          setView: {
            type: String,
            observer: '_methodObserver'
          }

        };
      }

      _registerMapOnChildren() {

        for (let i = 0; i < this.children.length; i++) {
          let m = this.children[i];
          m.container = this.obj;
        }

        // this._fitToMarkers();
      }

      _create(options) {
        L.Icon.Default.imagePath = "https://unpkg.com/leaflet@1.3.1/dist/images";

        console.log(JSON.stringify(options));
        // super.connectedCallback();

        this.obj = L.map(this.$.map, options);

        this._mapInitialized = false;

        // fire an event for when this.obj is defined and ready.
        // (needed for components that talk to this.obj directly)
        this.dispatchEvent(new CustomEvent('map-ready'));

        // update attributes
        this.obj.on('moveend zoomend dragend', function (e) {
          this._updateMapState();
        }, this);

        // forward events
        this.obj.on('click dblclick mousedown mouseup mouseover mouseout mousemove contextmenu focus blur preclick load unload viewreset movestart move moveend dragstart drag dragend zoomstart zoomend zoomlevelschange resize autopanstart layeradd layerremove baselayerchange overlayadd overlayremove locationfound locationerror popupopen popupclose', function (e) {
          this.dispatchEvent(new CustomEvent(e.type, e));
        }, this);

        // add a default layer if there are no layers defined
        // let defaultLayerRequired = true;
        // for (let i = 0; i < this.children.length; i++) {
        //   const e = this.children[i];
        //   if (e.isLayer && e.isLayer()) {
        //     defaultLayerRequired = false;
        //   }
        // }
        // if (defaultLayerRequired) {
          L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery &copy; <a href="http://mapbox.com">Mapbox</a>',
            maxZoom: 18
          }).addTo(this.obj);
        // }

        this._registerMapOnChildren();
        this._mutationObserver = new MutationObserver(this._registerMapOnChildren.bind(this));
        this._mutationObserver.observe(this, {childList: true});
      }

      detached() {
        this._mutationObserver.disconnect();
      }

      _updateMapState() {
        console.log(this.obj.getZoom());
        this.objState = JSON.stringify(
          {
            x: this.obj.getCenter().lng,
            y: this.obj.getCenter().lat,
            z: this.obj.getZoom()
          }
        );
      }

    }

    window.customElements.define(LeafletMap.is, LeafletMap);
  </script>
</dom-module>
