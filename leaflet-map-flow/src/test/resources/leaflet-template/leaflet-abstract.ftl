<link rel="import" href="leaflet-core.html">
<link rel="import" href="leaflet-layer.html">
<link rel="import" href="leaflet-control.html">


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
    static get properties() {

      return {

        <#list methodNames as m>
        ${m}: {
          type: String,
          observer : '_methodObserver'
        },

        </#list>
      }
    }


  }

</script>
