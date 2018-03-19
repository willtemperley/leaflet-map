<link rel="import" href="../polymer/polymer-element.html">

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
