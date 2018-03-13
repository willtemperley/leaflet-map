<link rel="import" href="leaflet-core.html">

<dom-module id="leaflet-scale-control">
	<template>
		<style>
			:host {display: none;}
		</style>
	</template>
	<script>
	"use strict";

	class ${className} extends LeafletCore {

		static get is(){
          return '${tagName}';
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
      if (this.options && this.container) {
        this._create(this.options);
      }
    }

		_create(options) {
      if (this.control) {
        return;
      }
      this.control = L.control.scale(options);
      this.control.addTo(this.container);
		}

		detached() {
			if (this.container && this.control) {
				this.container.removeControl(this.control);
			}
		}
	}
  window.customElements.define(LeafletScaleControl.is, LeafletScaleControl);
	</script>
</dom-module>
