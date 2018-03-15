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
          case 0: {
            this.obj = ${factoryMethod}();
            break;
          }
          case 1: {
            this.obj = ${factoryMethod}(args[0]);
            break;
          }
          case 2: {
            this.obj = ${factoryMethod}(args[0], args[1]);
            break;
          }
          case 3: {
            this.obj = ${factoryMethod}(args[0], args[1], args[2]);
            break;
          }
        }
        this.obj.addTo(this.container);
      }

      detached() {
		  //fixme
      }
	}
  window.customElements.define(${className}.is, ${className});
	</script>
</dom-module>
