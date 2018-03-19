<link rel="import" href="leaflet-core.html">

<dom-module id="leaflet-scale-control">
	<template>
		<style>
			:host {display: none;}
		</style>
	</template>
	<script>
	"use strict";

	class LeafletMarker extends LeafletLayer {

		static get is(){
          return 'leaflet-marker';
		}

    static get properties() {
      return {
        <#list methodNames as m>
          ${m}: {
            type: String,
            observer: '_methodObserver'
        },

        </#list>

          container: {
            type: Object,
            observer: '_containerChanged'
          }
        }
      }

      _containerChanged() {
        if (this.constructorargs && this.container) {
          this._construct(this.constructorargs);
        }
      }

      _construct(argString) {

        if (this.obj) {
          return;
        }

        if (!(this.constructorargs && this.container)) {
          return;
        }

        let invocation = JSON.parse(argString);
        let args = invocation.args;

        switch (args.length) {
          case 1: {
            this.obj = L.marker(args[0]);
            break;
          }
          case 2: {

            //replace icon config with instance
            let opts = args[1];
            //figure out what kind it is
            if (opts.icon) {
              if (opts.icon.className === 'leaflet-div-icon') {
                opts.icon = L.divIcon(opts.icon);
              } else if (opts.icon.html || opts.icon.bgPos) {
                opts.icon = L.divIcon(opts.icon);
              } else {
                opts.icon = L.icon(opts.icon);
              }
            }

            this.obj = L.marker(args[0], opts);
            break;
          }
        }
        this.obj.addTo(this.container);
      }

      detached() {
		  //fixme
      }
	}
  window.customElements.define(LeafletMarker.is, LeafletMarker);
	</script>
</dom-module>
